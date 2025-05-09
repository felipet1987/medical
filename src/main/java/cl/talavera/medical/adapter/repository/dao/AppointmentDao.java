package cl.talavera.medical.adapter.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AppointmentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientDao patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorDao doctor;

    private LocalDateTime dateTime;

    private String reason;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELLED
    }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
