package cm.ubuea.covider.registration.domain;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medical_id;

    @NotBlank
    private boolean current_status;

    @ElementCollection
    @CollectionTable(name = "current_user_symptoms", joinColumns = @JoinColumn(name = "medical_id"))
    @Column(name = "current_symptoms")
    private List<String> current_symptoms;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "c_user_med_record",
        joinColumns = {@JoinColumn(name = "medical_id", referencedColumnName = "medical_id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private User user;

    public MedicalRecord() {
    }

    public Long getMedical_id() {
        return medical_id;
    }

    public void setMedical_id(Long medical_id) {
        this.medical_id = medical_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
