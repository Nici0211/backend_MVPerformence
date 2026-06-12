package at.htlkaindorf.backend_mwperformence.controller;

import at.htlkaindorf.backend_mwperformence.dtos.VehicleDTO;
import at.htlkaindorf.backend_mwperformence.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  REST controller for vehicle management.
 * All routes require a valid JWT (enforced globally by Spring Security).
 * @author N
 */
@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    /**
     *  GET /api/vehicles/user/{userId} — returns all vehicles of a user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<VehicleDTO>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vehicleService.getByUserId(userId));
    }

    /**
     *  POST /api/vehicles/user/{userId} — creates a new vehicle for a user.
     */
    @PostMapping("/user/{userId}")
    public ResponseEntity<VehicleDTO> create(@PathVariable Long userId, @RequestBody VehicleDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.create(userId, dto));
    }

    /**
     *  PUT /api/vehicles/{id} — updates brand, model, buildYear and licensePlate.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Long id, @RequestBody VehicleDTO dto) {
        return ResponseEntity.ok(vehicleService.update(id, dto));
    }

    /**
     *  DELETE /api/vehicles/{id} — removes a vehicle.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}