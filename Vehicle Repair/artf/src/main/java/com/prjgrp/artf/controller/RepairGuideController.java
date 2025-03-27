// package com.prjgrp.artf.controller;

// import com.prjgrp.artf.entity.RepairGuide;
// import com.prjgrp.artf.service.RepairGuideService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/repair-guides")
// public class RepairGuideController {

//     @Autowired
//     private RepairGuideService repairGuideService;

//     @GetMapping
//     public List<RepairGuide> getAllRepairGuides() {
//         return repairGuideService.getAllRepairGuides();
//     }
//     @PostMapping
// public ResponseEntity<RepairGuide> createRepairGuide(@RequestBody RepairGuide repairGuide) {
//     RepairGuide createdGuide = repairGuideService.createRepairGuide(repairGuide);
//     return new ResponseEntity<>(createdGuide, HttpStatus.CREATED);
// }


//     @GetMapping("/{id}")
//     public Optional<RepairGuide> getRepairGuideById(@PathVariable Long id) {
//         return repairGuideService.getRepairGuideById(id);
//     }

   

//     @DeleteMapping("/{id}")
//     public void deleteRepairGuide(@PathVariable Long id) {
//         repairGuideService.deleteRepairGuide(id);
//     }
// }


package com.prjgrp.artf.controller;

import com.prjgrp.artf.entity.RepairGuide;
import com.prjgrp.artf.service.RepairGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair-guides")
public class RepairGuideController {

    @Autowired
    private RepairGuideService repairGuideService;

    // Create a new RepairGuide
    @PostMapping
    public ResponseEntity<RepairGuide> createRepairGuide(@RequestBody RepairGuide repairGuide) {
        RepairGuide createdRepairGuide = repairGuideService.createRepairGuide(repairGuide);
        return ResponseEntity.status(201).body(createdRepairGuide);
    }

    // Get all RepairGuides
    @GetMapping
    public ResponseEntity<List<RepairGuide>> getAllRepairGuides() {
        List<RepairGuide> repairGuides = repairGuideService.getAllRepairGuides();
        return ResponseEntity.ok(repairGuides);
    }

    // Get a RepairGuide by ID
    @GetMapping("/{id}")
    public ResponseEntity<RepairGuide> getRepairGuideById(@PathVariable Long id) {
        return repairGuideService.getRepairGuideById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a RepairGuide by ID
    @PutMapping("/{id}")
    public ResponseEntity<RepairGuide> updateRepairGuide(@PathVariable Long id, @RequestBody RepairGuide repairGuide) {
        RepairGuide updatedRepairGuide = repairGuideService.updateRepairGuide(id, repairGuide);
        return ResponseEntity.ok(updatedRepairGuide);
    }

    // Delete a RepairGuide by ID (optional, if needed for completeness)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepairGuide(@PathVariable Long id) {
        repairGuideService.deleteRepairGuide(id);
        return ResponseEntity.noContent().build();
    }
}
