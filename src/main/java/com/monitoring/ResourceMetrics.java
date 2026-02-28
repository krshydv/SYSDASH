package com.monitoring;

import java.util.List;

public class ResourceMetrics {

    private List<String> resourceNames;
    private List<Number> usageValues;
    private List<Integer> thresholds;

    public ResourceMetrics() {
    }

    public ResourceMetrics(List<String> resourceNames,
                           List<Number> usageValues,
                           List<Integer> thresholds) {
        this.resourceNames = resourceNames;
        this.usageValues = usageValues;
        this.thresholds = thresholds;
    }

    public List<String> getResourceNames() {
        return resourceNames;
    }

    public List<Number> getUsageValues() {
        return usageValues;
    }

    public List<Integer> getThresholds() {
        return thresholds;
    }
}