package cm.ubuea.covider.registration.service.dto;


import java.util.List;


public class MedicalRecordDTO {
    private boolean currentStatus;
    private List<String> currentSymptoms;
    private String userIdNumber;

    public MedicalRecordDTO() {
    }

    public boolean getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<String> getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(List<String> currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }
}
