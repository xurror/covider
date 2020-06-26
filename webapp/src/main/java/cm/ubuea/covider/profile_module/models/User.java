package cm.ubuea.covider.profile_module.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User implements Serializable {

    public User(User user) {
        this.cardnumber = user.getCardnumber();
        this.roles = user.getRole();
        this.password = user.getPassword();
    }

    public User() {
    }

    public User(String cardnumber, String password, Role role) {
        this.cardnumber = cardnumber;
        this.password = password;

        roles = new HashSet<>();
        roles.add(role);
    }

    @Id
    private String id;
    private String cardnumber;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }
}
