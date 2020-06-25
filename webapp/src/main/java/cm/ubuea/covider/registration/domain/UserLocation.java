package cm.ubuea.covider.registration.domain;


import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
import javax.validation.constraints.NotBlank;
>>>>>>> added functionality to add user's visited locations and medical status
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="c_location")
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;

    @NotNull
    @Size(max = 20)
    private String currentLoctaion;

    @ElementCollection
    @CollectionTable(name = "c_previous_user_location", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "previous_location")
    private List<String > previousLocation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_location",
        joinColumns = {@JoinColumn(name = "location_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id_number", referencedColumnName = "id_number")})
=======
    private Long location_id;

    @NotBlank
    @Size(max = 20)
    private String current_loctaion;

    @ElementCollection
    @CollectionTable(name = "previous_user_location", joinColumns = @JoinColumn(name = "location_id"))
    @Column(name = "previous_location")
    private List<String > previous_location;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_location",
        joinColumns = {@JoinColumn(name = "location_id", referencedColumnName = "location_id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
>>>>>>> added functionality to add user's visited locations and medical status
    private User user;

    public UserLocation() {
    }

<<<<<<< HEAD
    public Long getLocationId() {
        return id;
    }

    public void setLocationId(Long location_id) {
        this.id = id;
    }

    public String getCurrentLoctaion() {
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
=======
    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
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
>>>>>>> added functionality to add user's visited locations and medical status
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
