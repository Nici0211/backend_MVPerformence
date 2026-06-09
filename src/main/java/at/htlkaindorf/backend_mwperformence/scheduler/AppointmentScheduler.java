package at.htlkaindorf.backend_mwperformence.scheduler;

import at.htlkaindorf.backend_mwperformence.entites.Appointment;
import at.htlkaindorf.backend_mwperformence.entites.AppointmentStatus;
import at.htlkaindorf.backend_mwperformence.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 03.06.2026
 * Time: 19:11
 */


@Component
@RequiredArgsConstructor
public class AppointmentScheduler {

    private final AppointmentRepository appointmentRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void autoSetAusstehend() {
        LocalDateTime cutoff = LocalDateTime.now().minusDays(7);

        List<Appointment> toUpdate = appointmentRepository
                .findByStatusAndCreatedAtBefore(AppointmentStatus.NEU, cutoff);

        toUpdate.forEach(a -> a.setStatus(AppointmentStatus.AUSSTEHEND));
        appointmentRepository.saveAll(toUpdate);
    }
}