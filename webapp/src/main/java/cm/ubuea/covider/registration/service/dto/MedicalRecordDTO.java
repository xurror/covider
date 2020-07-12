package cm.ubuea.covider.registration.service.dto;

import java.util.List;

public class MedicalRecordDTO {

    private String idNumber;
    private boolean currentStatus;
    private List<String> currentSymptoms;

    public MedicalRecordDTO() {
    }

    public boolean getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(final boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<String> getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(final List<String> currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final String idNumber) {
        this.idNumber = idNumber;
    }
}
