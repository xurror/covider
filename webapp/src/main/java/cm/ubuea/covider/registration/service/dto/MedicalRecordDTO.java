package cm.ubuea.covider.registration.service.dto;


import java.util.List;


public class MedicalRecordDTO {
    private boolean current_status;
    private List<String> current_symptoms;
    private Long userid;

    public MedicalRecordDTO() {
    }

    public boolean isCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(boolean current_status) {
        this.current_status = current_status;
    }

    public List<String> getCurrent_symptoms() {
        return current_symptoms;
    }

    public void setCurrent_symptoms(List<String> current_symptoms) {
        this.current_symptoms = current_symptoms;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
