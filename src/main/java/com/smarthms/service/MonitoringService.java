package com.smarthms.service;

import com.smarthms.model.Alert;
import com.smarthms.model.VitalSigns;
import com.smarthms.repository.VitalsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringService {

    private final VitalsRepository vitalsRepository;
    private final AlertService alertService;

    public MonitoringService(VitalsRepository vitalsRepository, AlertService alertService) {
        this.vitalsRepository = vitalsRepository;
        this.alertService = alertService;
    }

    public List<Alert> ingestVitals(VitalSigns vitalSigns) {
        vitalsRepository.save(vitalSigns);
        return alertService.evaluate(vitalSigns);
    }

    public List<VitalSigns> getPatientHistory(String patientId) {
        return vitalsRepository.findByPatientId(patientId);
    }
}
