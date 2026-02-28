package com.monitoring;

public class MetricsOverview {

    private double cpu;
    private double memory;
    private double disk;
    private double jvmHeap;
    private int threads;
    private String uptime;
    private double apiResponseTime;
    private String status;

    public MetricsOverview(double cpu,
                           double memory,
                           double disk,
                           double jvmHeap,
                           int threads,
                           String uptime,
                           double apiResponseTime,
                           String status) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.jvmHeap = jvmHeap;
        this.threads = threads;
        this.uptime = uptime;
        this.apiResponseTime = apiResponseTime;
        this.status = status;
    }

    public double getCpu() { return cpu; }
    public double getMemory() { return memory; }
    public double getDisk() { return disk; }
    public double getJvmHeap() { return jvmHeap; }
    public int getThreads() { return threads; }
    public String getUptime() { return uptime; }
    public double getApiResponseTime() { return apiResponseTime; }
    public String getStatus() { return status; }
}