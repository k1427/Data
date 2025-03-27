package com.prjgrp.artf.service;

import com.prjgrp.artf.entity.Maintenance;
import com.prjgrp.artf.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public Optional<Maintenance> getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id);
    }

    public void deleteMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }
}
