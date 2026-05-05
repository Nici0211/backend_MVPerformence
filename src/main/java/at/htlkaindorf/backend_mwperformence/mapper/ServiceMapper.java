package at.htlkaindorf.backend_mwperformence.mapper;

import at.htlkaindorf.backend_mwperformence.dtos.ServiceEntityDTO;
import at.htlkaindorf.backend_mwperformence.entites.ServiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 25.03.2026
 * Time: 12:53
 */
@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceEntity toEntity(ServiceEntityDTO serviceDTO);

    List<ServiceEntity> toEntity(List<ServiceEntityDTO> serviceDTO);

    ServiceEntityDTO toDto(ServiceEntity service);

    List<ServiceEntityDTO> toDto(List<ServiceEntity> service);
}
