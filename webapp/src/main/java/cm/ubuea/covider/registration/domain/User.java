package cm.ubuea.covider.registration.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
=======

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
>>>>>>> from upstream updates
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
<<<<<<< HEAD
@Table(name="c_user")
public class User extends AbstractAuditingEntity {

    private static final long serialVersionUID = 1L;
=======
@Table(name="user")
public class User extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1520540783775614588L;
>>>>>>> from upstream updates

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD

=======
    
>>>>>>> from upstream updates
    @NotNull
    @Column(name = "id_number", unique = true, nullable = false)
    private String idNumber;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "activated", nullable = false)
    private boolean activated = false;

    @Size(min = 2, max = 10)
    @Column(name = "lang_key", length = 10)
    private String langKey;

    @Size(max = 20)
    @Column(name = "activation_key", length = 20)
    @JsonIgnore
    private String activationKey;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;

    @Column(name = "reset_date")
    private LocalDateTime resetDate;

<<<<<<< HEAD
    @ManyToMany
    @JoinTable(name = "c_user_role",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")})
    private Set<Role> roles;

    @OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
    private UserLocation userLocation;

    @OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
    private MedicalRecord medicalRecord;

=======
    @ElementCollection
    @CollectionTable(
            name="authority",
            joinColumns=@JoinColumn(name="id_number")
    )
    @Column(name = "user_authority")
    private Set<String> authorities;
>>>>>>> from upstream updates

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return this.idNumber;
    }
<<<<<<< HEAD

=======
        
>>>>>>> from upstream updates
    public void setIdNumber(final String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public LocalDateTime getResetDate() {
        return resetDate;
    }

    public void setResetDate(LocalDateTime resetDate) {
        this.resetDate = resetDate;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

<<<<<<< HEAD
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
=======
    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
>>>>>>> from upstream updates
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
            "email='" + email + '\'' +
            ", name='" + name + '\'' +
<<<<<<< HEAD
            ", roles='" + roles + '\'' +
=======
>>>>>>> from upstream updates
            ", idNumber='" + idNumber + '\'' +
            ", activated='" + activated + '\'' +
            ", langKey='" + langKey + '\'' +
            ", activationKey='" + activationKey + '\'' +
            "}";
    }




}
