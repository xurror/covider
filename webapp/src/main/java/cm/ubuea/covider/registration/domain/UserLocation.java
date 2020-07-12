package cm.ubuea.covider.registration.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="c_location")
public class UserLocation implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    private String currentLocation;

    @ElementCollection
    @CollectionTable(name = "c_previous_user_location", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "previous_location")
    private List<String > previousLocation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_location",
        joinColumns = {@JoinColumn(name = "location_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id_number", referencedColumnName = "id_number")})
    private User user;

    public UserLocation() {
    }

    public Long getLocationId() {
        return id;
    }

    public void setLocationId(Long id) {
        this.id = id;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public List<String> getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(List<String> previousLocation) {
        this.previousLocation = previousLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
