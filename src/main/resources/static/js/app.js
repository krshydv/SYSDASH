let performanceChart = null;

// ===============================
// LOAD OVERVIEW
// ===============================
async function loadOverview() {
    try {
        const response = await fetch("/metrics/overview");
        if (!response.ok) throw new Error("Overview API failed");

        const data = await response.json();

        document.querySelector(".cpu-value").innerText = data.cpu + "%";
        document.querySelector(".memory-value").innerText = data.memory + "%";
        document.querySelector(".disk-value").innerText = data.disk + "%";
        document.querySelector(".threads-value").innerText = data.threads;

        const statusBadge = document.querySelector(".status-badge");
        statusBadge.innerText = data.status;

        if (data.status === "HEALTHY") {
            statusBadge.style.backgroundColor = "#22c55e";
        } else {
            statusBadge.style.backgroundColor = "#ef4444";
        }

    } catch (error) {
        console.error("Overview Error:", error);
    }
}

// ===============================
// LOAD HISTORY
// ===============================
async function loadHistory() {
    try {
        const response = await fetch("/metrics/history?window=1h");
        if (!response.ok) throw new Error("History API failed");

        const data = await response.json();

        const canvas = document.getElementById("performanceChart");
        if (!canvas) return;

        const ctx = canvas.getContext("2d");

        if (performanceChart) {
            performanceChart.destroy();
        }

        performanceChart = new Chart(ctx, {
            type: "line",
            data: {
                labels: data.timestamps,
                datasets: [
                    {
                        label: "CPU (%)",
                        data: data.cpu,
                        borderColor: "#4cc9f0",
                        tension: 0.4
                    },
                    {
                        label: "Memory (%)",
                        data: data.memory,
                        borderColor: "#80ed99",
                        tension: 0.4
                    },
                    {
                        label: "Disk (%)",
                        data: data.disk,
                        borderColor: "#f72585",
                        tension: 0.4
                    },
                    {
                        label: "Threads",
                        data: data.threads,
                        borderColor: "#ffbe0b",
                        tension: 0.4
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        labels: {
                            color: "#ffffff"
                        }
                    }
                },
                scales: {
                    x: {
                        ticks: { color: "#ffffff" },
                        grid: { color: "rgba(255,255,255,0.05)" }
                    },
                    y: {
                        ticks: { color: "#ffffff" },
                        grid: { color: "rgba(255,255,255,0.05)" }
                    }
                }
            }
        });

    } catch (error) {
        console.error("History Error:", error);
    }
}

// ===============================
// INITIAL LOAD
// ===============================
document.addEventListener("DOMContentLoaded", () => {
    console.log("Dashboard Loaded");

    loadOverview();
    loadHistory();


    setInterval(() => {
        loadOverview();
        loadHistory();
    }, 10000);
});