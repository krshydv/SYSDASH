package com.monitoring;

public class DbPoolMetrics {

    private int activeConnections;
    private int idleConnections;
    private int maxConnections;
    private int minConnections;
    private int pendingRequests;
    private long connectionTimeout;
    private long maxLifetime;

    public DbPoolMetrics() {
    }

    public DbPoolMetrics(int activeConnections,
                         int idleConnections,
                         int maxConnections,
                         int minConnections,
                         int pendingRequests,
                         long connectionTimeout,
                         long maxLifetime) {

        this.activeConnections = activeConnections;
        this.idleConnections = idleConnections;
        this.maxConnections = maxConnections;
        this.minConnections = minConnections;
        this.pendingRequests = pendingRequests;
        this.connectionTimeout = connectionTimeout;
        this.maxLifetime = maxLifetime;
    }

    public int getActiveConnections() {
        return activeConnections;
    }

    public int getIdleConnections() {
        return idleConnections;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public int getPendingRequests() {
        return pendingRequests;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public long getMaxLifetime() {
        return maxLifetime;
    }
}