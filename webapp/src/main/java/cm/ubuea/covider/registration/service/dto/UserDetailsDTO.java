package cm.ubuea.covider.registration.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDetailsDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private String idNumber;

    @Size(max = 50)
    private String name;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    private boolean current_status;

    private List<String> current_symptoms;

    private String current_loctaion;

    private List<String > previous_location;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCurrent_loctaion() {
        return current_loctaion;
    }

    public void setCurrent_loctaion(String current_loctaion) {
        this.current_loctaion = current_loctaion;
    }

    public List<String> getPrevious_location() {
        return previous_location;
    }

    public void setPrevious_location(List<String> previous_location) {
        this.previous_location = previous_location;
    }
}
