package com.monitoring;

public class LogEntry {

    private long id;
    private String level;
    private String message;
    private String source;
    private long timestamp;

    public LogEntry(long id,
                    String level,
                    String message,
                    String source,
                    long timestamp) {
        this.id = id;
        this.level = level;
        this.message = message;
        this.source = source;
        this.timestamp = timestamp;
    }

    public long getId() { return id; }
    public String getLevel() { return level; }
    public String getMessage() { return message; }
    public String getSource() { return source; }
    public long getTimestamp() { return timestamp; }
}