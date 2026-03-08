package com.smarthms;

import com.smarthms.model.Alert;
import com.smarthms.model.VitalSigns;
import com.smarthms.service.AlertService;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlertServiceTest {

    private final AlertService alertService = new AlertService();

    @Test
    void shouldTriggerCriticalAlertForLowOxygen() {
        VitalSigns vitalSigns = new VitalSigns();
        vitalSigns.setPatientId("patient-1");
        vitalSigns.setHeartRate(82);
        vitalSigns.setSystolicBp(120);
        vitalSigns.setDiastolicBp(80);
        vitalSigns.setOxygenSaturation(84);
        vitalSigns.setRecordedAt(Instant.now());

        List<Alert> alerts = alertService.evaluate(vitalSigns);

        assertFalse(alerts.isEmpty());
        assertTrue(alerts.stream().anyMatch(alert -> "CRITICAL".equals(alert.getSeverity())));
    }
}
