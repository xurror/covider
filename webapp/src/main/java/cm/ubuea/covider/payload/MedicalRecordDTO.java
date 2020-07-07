package ub.covid.fet.payload;

import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordDTO {
    private boolean current_status;
    private List<String> current_symptoms;
    private long userid;
}
