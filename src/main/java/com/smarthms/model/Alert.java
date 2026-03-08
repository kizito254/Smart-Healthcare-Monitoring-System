package com.smarthms.model;

import java.time.Instant;

public class Alert {
    private final String patientId;
    private final String severity;
    private final String message;
    private final Instant triggeredAt;

    public Alert(String patientId, String severity, String message, Instant triggeredAt) {
        this.patientId = patientId;
        this.severity = severity;
        this.message = message;
        this.triggeredAt = triggeredAt;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTriggeredAt() {
        return triggeredAt;
    }
}
