package com.smarthms.controller;

import com.smarthms.model.Alert;
import com.smarthms.model.VitalSigns;
import com.smarthms.service.MonitoringService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @PostMapping("/vitals")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Alert> ingestVitals(@Valid @RequestBody VitalSigns vitalSigns) {
        return monitoringService.ingestVitals(vitalSigns);
    }

    @GetMapping("/patients/{patientId}/history")
    public List<VitalSigns> getHistory(@PathVariable String patientId) {
        return monitoringService.getPatientHistory(patientId);
    }
}
