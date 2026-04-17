package at.htlkaindorf.backend_mwperformence.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 27.03.2026
 * Time: 11:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "service_type", nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private String vehicle;

    @Column(name = "preferred_date", nullable = false)
    private LocalDateTime preferredDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AppointmentStatus status = AppointmentStatus.NEU;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "vehicle_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicle vehicleEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "service_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Service service;
}
