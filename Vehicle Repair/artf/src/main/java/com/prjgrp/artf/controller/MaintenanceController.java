package com.prjgrp.artf.controller;

import com.prjgrp.artf.entity.Maintenance;
import com.prjgrp.artf.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> createMaintenance(@RequestBody Maintenance maintenance) {
        Maintenance createdMaintenance = maintenanceService.createMaintenance(maintenance);
        return new ResponseEntity<>(createdMaintenance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAllMaintenances() {
        List<Maintenance> maintenances = maintenanceService.getAllMaintenances();
        return ResponseEntity.ok(maintenances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long id) {
        Optional<Maintenance> maintenance = maintenanceService.getMaintenanceById(id);
        return maintenance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
