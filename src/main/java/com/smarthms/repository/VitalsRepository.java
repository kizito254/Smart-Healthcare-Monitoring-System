package com.smarthms.repository;

import com.smarthms.model.VitalSigns;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VitalsRepository {

    private final Map<String, List<VitalSigns>> vitalsByPatient = new ConcurrentHashMap<>();

    public void save(VitalSigns vitalSigns) {
        vitalsByPatient.computeIfAbsent(vitalSigns.getPatientId(), key -> Collections.synchronizedList(new ArrayList<>()))
                .add(vitalSigns);
    }

    public List<VitalSigns> findByPatientId(String patientId) {
        return new ArrayList<>(vitalsByPatient.getOrDefault(patientId, List.of()));
    }
}
