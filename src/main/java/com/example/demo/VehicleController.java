package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepo;

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle existingVehicle = vehicleRepo.findById(id).orElseThrow();
        existingVehicle.setMake(vehicleDetails.getMake());
        existingVehicle.setModel(vehicleDetails.getModel());
        existingVehicle.setYear(vehicleDetails.getYear());

        return vehicleRepo.save(existingVehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepo.deleteById(id);
    }
}
