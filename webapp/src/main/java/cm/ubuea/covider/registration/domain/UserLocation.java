package cm.ubuea.covider.registration.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="c_location")
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_id;

    @NotBlank
    @Size(max = 20)
    private String current_loctaion;

    @ElementCollection
    @CollectionTable(name = "previous_user_location", joinColumns = @JoinColumn(name = "location_id"))
    @Column(name = "previous_location")
    private List<String > previous_location;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_location",
        joinColumns = {@JoinColumn(name = "location_id", referencedColumnName = "location_id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private User user;

    public UserLocation() {
    }

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
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
