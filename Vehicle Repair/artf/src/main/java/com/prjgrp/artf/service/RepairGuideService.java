// // package com.prjgrp.artf.service;

// // import com.prjgrp.artf.entity.RepairGuide;
// // import com.prjgrp.artf.repository.RepairGuideRepository;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;

// // import java.util.List;
// // import java.util.Optional;

// // @Service
// // public class RepairGuideService {

// //     @Autowired
// //     private RepairGuideRepository repairGuideRepository;

// //     public RepairGuide createRepairGuide(RepairGuide repairGuide) {
// //         return repairGuideRepository.save(repairGuide);
// //     }

// //     public List<RepairGuide> getAllRepairGuides() {
// //         return repairGuideRepository.findAll();
// //     }

// //     public Optional<RepairGuide> getRepairGuideById(Long id) {
// //         return repairGuideRepository.findById(id);
// //     }

// //     public void deleteRepairGuide(Long id) {
// //         repairGuideRepository.deleteById(id);
// //     }
// // }


// package com.prjgrp.artf.service;

// import com.prjgrp.artf.entity.RepairGuide;
// import com.prjgrp.artf.repository.RepairGuideRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RepairGuideService {

//     @Autowired
//     private RepairGuideRepository repairGuideRepository;

//     public RepairGuide createRepairGuide(RepairGuide repairGuide) {
//         return repairGuideRepository.save(repairGuide);
//     }

//     public List<RepairGuide> getAllRepairGuides() {
//         return repairGuideRepository.findAll();
//     }
// }


package com.prjgrp.artf.service;

import com.prjgrp.artf.entity.RepairGuide;
import com.prjgrp.artf.repository.RepairGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairGuideService {

    @Autowired
    private RepairGuideRepository repairGuideRepository;

    // Create a new RepairGuide
    public RepairGuide createRepairGuide(RepairGuide repairGuide) {
        return repairGuideRepository.save(repairGuide);
    }

    // Get all RepairGuides
    public List<RepairGuide> getAllRepairGuides() {
        return repairGuideRepository.findAll();
    }

    // Get a RepairGuide by ID
    public Optional<RepairGuide> getRepairGuideById(Long id) {
        return repairGuideRepository.findById(id);
    }

    // Update a RepairGuide by ID
    public RepairGuide updateRepairGuide(Long id, RepairGuide repairGuideDetails) {
        return repairGuideRepository.findById(id).map(repairGuide -> {
            repairGuide.setTitle(repairGuideDetails.getTitle());
            repairGuide.setDescription(repairGuideDetails.getDescription());
            return repairGuideRepository.save(repairGuide);
        }).orElseThrow(() -> new RuntimeException("Repair guide not found with id: " + id));
    }

    // Delete a RepairGuide by ID (optional, if needed for completeness)
    public void deleteRepairGuide(Long id) {
        repairGuideRepository.deleteById(id);
    }
}
