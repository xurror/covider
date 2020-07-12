package cm.ubuea.covider.registration.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="c_medical_record")
public class MedicalRecord implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean currentStatus;

    @ElementCollection
    @CollectionTable(name = "c_current_user_symptoms", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "current_symptoms")
    private List<String> currentSymptoms;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_med_record",
        joinColumns = {@JoinColumn(name = "medical_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id_number", referencedColumnName = "id_number")})
    private User user;

    public MedicalRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<String> getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(List<String> currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
