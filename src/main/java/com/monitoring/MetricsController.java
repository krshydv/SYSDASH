package com.monitoring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@CrossOrigin
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    // =========================
    // OVERVIEW
    // =========================
    @GetMapping("/overview")
    public ResponseEntity<MetricsOverview> getOverview() {
        return ResponseEntity.ok(metricsService.collectOverview());
    }

    // =========================
    // HISTORY
    // =========================
    @GetMapping("/history")
    public ResponseEntity<MetricsHistory> getHistory(
            @RequestParam(defaultValue = "1h") String window) {
        return ResponseEntity.ok(metricsService.collectHistory(window));
    }

    // =========================
    // RESOURCES
    // =========================
    @GetMapping("/resources")
    public ResponseEntity<ResourceMetrics> getResources() {
        return ResponseEntity.ok(metricsService.collectResourceMetrics());
    }

    // =========================
    // DATABASE POOL
    // =========================
    @GetMapping("/dbpool")
    public ResponseEntity<DbPoolMetrics> getDbPool() {
        return ResponseEntity.ok(metricsService.collectDbPoolMetrics());
    }

    // =========================
    // ALERTS
    // =========================
    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAlerts(
            @RequestParam(defaultValue = "") String severity,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(metricsService.getAlerts(severity, limit));
    }

    // =========================
    // LOGS
    // =========================
    @GetMapping("/logs")
    public ResponseEntity<List<LogEntry>> getLogs(
            @RequestParam(defaultValue = "") String level,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(metricsService.getLogs(level, search, limit));
    }
}