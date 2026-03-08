package com.smarthms.service;

import com.smarthms.model.Alert;
import com.smarthms.model.VitalSigns;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    public List<Alert> evaluate(VitalSigns vitalSigns) {
        List<Alert> alerts = new ArrayList<>();

        if (vitalSigns.getHeartRate() >= 130 || vitalSigns.getHeartRate() <= 40) {
            alerts.add(new Alert(vitalSigns.getPatientId(), "CRITICAL",
                    "Abnormal heart rate detected", Instant.now()));
        }

        if (vitalSigns.getOxygenSaturation() <= 88) {
            alerts.add(new Alert(vitalSigns.getPatientId(), "CRITICAL",
                    "Low oxygen saturation detected", Instant.now()));
        }

        if (vitalSigns.getSystolicBp() >= 180 || vitalSigns.getDiastolicBp() >= 120) {
            alerts.add(new Alert(vitalSigns.getPatientId(), "HIGH",
                    "Hypertensive crisis threshold reached", Instant.now()));
        }

        return alerts;
    }
}
