package cm.ubuea.covider.registration.service.dto;




import java.util.List;


public class LocationDTO {
    private String currentLoctaion;
    private List<String > previousLocation;
    private String userIdNumber;

    public LocationDTO() {
    }

    public String getCurrentloctaion() {
        return currentLoctaion;
    }

    public void setCurrentLoctaion(String currentLoctaion) {
        this.currentLoctaion = currentLoctaion;
    }

    public List<String> getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(List<String> previousLocation) {
        this.previousLocation = previousLocation;
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserid(String useridNumber) {
        this.userIdNumber = useridNumber;
    }
}
