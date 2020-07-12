package cm.ubuea.covider.registration.service.dto;

import java.util.List;

public class UserLocationDTO {

    private String idNumber;

    private String currentLocation;

    private List<String> previousLocation;


    public UserLocationDTO() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public List<String> getPreviousLocation() {
        return previousLocation;
    }

    public void setIdNumber(final String idNumber) {
        this.idNumber = idNumber;
    }

    public void setCurrentLocation(final String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setPreviousLocation(final List<String> previousLocation) {
        this.previousLocation = previousLocation;
    }
}

