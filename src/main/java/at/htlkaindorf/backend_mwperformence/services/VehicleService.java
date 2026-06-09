package at.htlkaindorf.backend_mwperformence.services;

import at.htlkaindorf.backend_mwperformence.dtos.VehicleDTO;
import at.htlkaindorf.backend_mwperformence.entites.User;
import at.htlkaindorf.backend_mwperformence.entites.Vehicle;
import at.htlkaindorf.backend_mwperformence.exception.ApiException;
import at.htlkaindorf.backend_mwperformence.mapper.VehicleMapper;
import at.htlkaindorf.backend_mwperformence.repositories.UserRepository;
import at.htlkaindorf.backend_mwperformence.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final VehicleMapper vehicleMapper;


    public List<VehicleDTO> getByUserId(Long userId) {
        return vehicleRepository.findAllByUserId(userId)
                .stream()
                .map(vehicleMapper::toDTO)
                .toList();
    }


    @Transactional
    public VehicleDTO create(Long userId, VehicleDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException("Benutzer nicht gefunden.", HttpStatus.NOT_FOUND));

        Vehicle vehicle = Vehicle.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .buildYear(dto.getBuildYear())
                .licensePlate(dto.getLicensePlate())
                .user(user)
                .appointments(new ArrayList<>())
                .build();

        return vehicleMapper.toDTO(vehicleRepository.save(vehicle));
    }


    @Transactional
    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ApiException("Fahrzeug nicht gefunden.", HttpStatus.NOT_FOUND));

        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setBuildYear(dto.getBuildYear());
        vehicle.setLicensePlate(dto.getLicensePlate());

        return vehicleMapper.toDTO(vehicleRepository.save(vehicle));
    }


    @Transactional
    public void delete(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ApiException("Fahrzeug nicht gefunden.", HttpStatus.NOT_FOUND);
        }
        vehicleRepository.deleteById(id);
    }
}
