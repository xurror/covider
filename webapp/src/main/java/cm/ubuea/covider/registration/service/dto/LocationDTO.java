package cm.ubuea.covider.registration.service.dto;




import java.util.List;


public class LocationDTO {
    private String current_loctaion;
    private List<String > previous_location;
<<<<<<< HEAD
    private String userIdNumber;
=======
    private Long userid;
>>>>>>> added functionality to add user's visited locations and medical status

    public LocationDTO() {
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

<<<<<<< HEAD
    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserid(String useridNumber) {
        this.userIdNumber = useridNumber;
=======
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
>>>>>>> added functionality to add user's visited locations and medical status
    }
}
