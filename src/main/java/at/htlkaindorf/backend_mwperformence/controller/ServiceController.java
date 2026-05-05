package at.htlkaindorf.backend_mwperformence.controller;


import at.htlkaindorf.backend_mwperformence.dtos.ServiceEntityDTO;
import at.htlkaindorf.backend_mwperformence.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 27.03.2026
 * Time: 09:47
 */

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceEntityDTO>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }
}
