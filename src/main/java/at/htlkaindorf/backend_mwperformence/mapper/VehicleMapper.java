package at.htlkaindorf.backend_mwperformence.mapper;

import at.htlkaindorf.backend_mwperformence.dtos.VehicleDTO;
import at.htlkaindorf.backend_mwperformence.entites.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(source = "user.id", target = "userId")
    VehicleDTO toDTO(Vehicle vehicle);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "appointments", ignore = true)
    Vehicle toEntity(VehicleDTO dto);
}
