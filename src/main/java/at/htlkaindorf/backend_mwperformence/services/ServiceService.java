package at.htlkaindorf.backend_mwperformence.services;

import at.htlkaindorf.backend_mwperformence.dtos.ServiceEntityDTO;
import at.htlkaindorf.backend_mwperformence.entites.ServiceEntity;
import at.htlkaindorf.backend_mwperformence.mapper.ServiceMapper;
import at.htlkaindorf.backend_mwperformence.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public List<ServiceEntityDTO> getAllServices() {
        return serviceMapper.toDto(serviceRepository.findAll());
    }

    public ServiceEntityDTO getServiceById(Long id) {
        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found: " + id));
        return serviceMapper.toDto(service);
    }

    public ServiceEntityDTO createService(ServiceEntityDTO dto) {
        ServiceEntity saved = serviceRepository.save(serviceMapper.toEntity(dto));
        return serviceMapper.toDto(saved);
    }

    public ServiceEntityDTO updateService(Long id, ServiceEntityDTO dto) {
        serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found: " + id));
        ServiceEntity entity = serviceMapper.toEntity(dto);
        entity.setId(id);
        return serviceMapper.toDto(serviceRepository.save(entity));
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}