package com.monitoring;

public class Alert {

    private long id;
    private String title;
    private String description;
    private String severity;
    private String source;
    private boolean resolved;
    private long timestamp;

    public Alert() {
    }

    public Alert(long id,
                 String title,
                 String description,
                 String severity,
                 String source,
                 boolean resolved) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.source = source;
        this.resolved = resolved;
        this.timestamp = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getSource() {
        return source;
    }

    public boolean isResolved() {
        return resolved;
    }

    public long getTimestamp() {
        return timestamp;
    }
}