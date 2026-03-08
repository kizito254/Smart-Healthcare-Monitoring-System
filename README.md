# Smart Healthcare Monitoring System

A Java-based backend starter for collecting real-time patient vitals from wearable/IoT devices, triggering emergency alerts, and exposing patient history through REST APIs.

## Core Features

- **Real-time health monitoring** via a vitals ingestion endpoint.
- **Emergency alerts** generated from configurable thresholds (heart rate, SpO2, blood pressure).
- **Patient history dashboard support** via a patient history API endpoint.
- **Cloud-storage ready architecture** through repository/service abstractions.

## Tech Stack

- Java 17
- Spring Boot (REST APIs + validation)
- IoT-compatible JSON ingestion endpoint
- Repository layer that can be swapped to cloud persistence

## API Endpoints

### 1) Ingest vitals

`POST /api/v1/vitals`

Example payload:

```json
{
  "patientId": "patient-101",
  "heartRate": 132,
  "systolicBp": 182,
  "diastolicBp": 121,
  "oxygenSaturation": 86,
  "recordedAt": "2026-01-15T08:30:00Z"
}
```

Response: array of triggered alerts.

### 2) Fetch patient history

`GET /api/v1/patients/{patientId}/history`

Response: list of previously ingested vitals for the patient.

## Run Locally

```bash
mvn spring-boot:run
```

## Run Tests

```bash
mvn test
```

## Next Steps for Production

- Replace in-memory repository with managed cloud database storage (e.g., DynamoDB, Firestore, PostgreSQL).
- Integrate device authentication and signed payload validation.
- Push alert events to messaging channels (SMS/email/pager/webhooks).
- Add a frontend dashboard for clinicians.
