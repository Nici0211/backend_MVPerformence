package at.htlkaindorf.backend_mwperformence.repositories;

import at.htlkaindorf.backend_mwperformence.entites.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 25.03.2026
 * Time: 12:36
 */
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}

