package com.monitoring;

import java.util.List;

public class MetricsHistory {

    private List<String> timestamps;
    private List<Double> cpu;
    private List<Double> memory;
    private List<Double> disk;
    private List<Integer> threads;

    public MetricsHistory(List<String> timestamps,
                          List<Double> cpu,
                          List<Double> memory,
                          List<Double> disk,
                          List<Integer> threads) {
        this.timestamps = timestamps;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.threads = threads;
    }

    public List<String> getTimestamps() { return timestamps; }
    public List<Double> getCpu() { return cpu; }
    public List<Double> getMemory() { return memory; }
    public List<Double> getDisk() { return disk; }
    public List<Integer> getThreads() { return threads; }
}