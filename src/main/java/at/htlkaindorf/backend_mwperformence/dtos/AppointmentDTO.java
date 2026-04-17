package at.htlkaindorf.backend_mwperformence.dtos;

import at.htlkaindorf.backend_mwperformence.entites.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 27.03.2026
 * Time: 11:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;
    private String customerName;
    private String serviceType;
    private String vehicle;
    private LocalDateTime preferredDate;
    private AppointmentStatus status;
}
