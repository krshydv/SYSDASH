package com.monitoring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsService {

    // =========================
    // OVERVIEW
    // =========================
    public MetricsOverview collectOverview() {
        return new MetricsOverview(
                35.5,     // CPU
                60.2,     // Memory
                70.1,     // Disk
                45.3,     // Network (example extra)
                120,      // Threads
                "2h 15m", // Uptime
                120.5,    // Throughput
                "HEALTHY" // Status
        );
    }

    // =========================
    // HISTORY (FOR CHARTS)
    // =========================
    public MetricsHistory collectHistory(String window) {

        List<String> timestamps = List.of(
                "10:00", "10:05", "10:10",
                "10:15", "10:20", "10:25"
        );

        List<Double> cpu = List.of(
                30.0, 45.0, 38.0,
                50.0, 42.0, 35.0
        );

        List<Double> memory = List.of(
                55.0, 60.0, 65.0,
                63.0, 70.0, 68.0
        );

        List<Double> disk = List.of(
                60.0, 62.0, 65.0,
                70.0, 72.0, 75.0
        );

        List<Integer> threads = List.of(
                100, 120, 110,
                130, 125, 118
        );

        return new MetricsHistory(
                timestamps,
                cpu,
                memory,
                disk,
                threads
        );
    }

    // =========================
    // RESOURCE METRICS
    // =========================
    public ResourceMetrics collectResourceMetrics() {
        return new ResourceMetrics(
                List.of("CPU", "Memory", "Disk"),
                List.of(35.0, 60.0, 70.0),
                List.of(100, 200, 300)
        );
    }

    // =========================
    // DATABASE POOL METRICS
    // =========================
    public DbPoolMetrics collectDbPoolMetrics() {
        return new DbPoolMetrics(
                10,   // active
                5,    // idle
                15,   // total
                2,    // pending
                20,   // max
                100L, // min wait
                200L  // max wait
        );
    }

    // =========================
    // ALERTS
    // =========================
    public List<Alert> getAlerts(String severity, int limit) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert(
                1L,
                "HIGH",
                "CPU Usage High",
                "CPU exceeded 80%",
                "SYSTEM",
                false
        ));

        alerts.add(new Alert(
                2L,
                "MEDIUM",
                "Memory Warning",
                "Memory exceeded 70%",
                "SYSTEM",
                false
        ));

        return alerts;
    }

    // =========================
    // LOGS
    // =========================
    public List<LogEntry> getLogs(String level, String search, int limit) {

        List<LogEntry> logs = new ArrayList<>();

        logs.add(new LogEntry(
                1L,
                "INFO",
                "Application started",
                "SYSTEM",
                System.currentTimeMillis()
        ));

        logs.add(new LogEntry(
                2L,
                "WARN",
                "Memory usage increasing",
                "SYSTEM",
                System.currentTimeMillis()
        ));

        return logs;
    }
}