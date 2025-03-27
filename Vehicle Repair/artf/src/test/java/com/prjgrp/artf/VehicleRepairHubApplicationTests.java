package com.prjgrp.artf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjgrp.artf.controller.DiagnosticController;
import com.prjgrp.artf.controller.ForumController;
import com.prjgrp.artf.controller.MaintenanceController;
import com.prjgrp.artf.controller.RepairGuideController;
import com.prjgrp.artf.entity.*;
import com.prjgrp.artf.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.tools.DiagnosticCollector;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({RepairGuideController.class, MaintenanceController.class, DiagnosticController.class, ForumController.class})
public class VehicleRepairHubApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RepairGuideService repairGuideService;

    @MockBean
    private MaintenanceService maintenanceService;

    @MockBean
    private DiagnosticService diagnosticService;

    @MockBean
    private ForumService forumService;

    // RepairGuide Tests
    @Test
    public void createRepairGuideTest() throws Exception {
        RepairGuide repairGuide = new RepairGuide(1L, "Engine Repair", "Engine repair details");

        Mockito.when(repairGuideService.createRepairGuide(any(RepairGuide.class))).thenReturn(repairGuide);

        mockMvc.perform(post("/repair-guides")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(repairGuide)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Engine Repair"));
    }

    @Test
    public void getAllRepairGuidesTest() throws Exception {
        List<RepairGuide> repairGuides = Arrays.asList(
                new RepairGuide(1L, "Engine Repair", "Engine repair details"),
                new RepairGuide(2L, "Brake Repair", "Brake repair details")
        );

        Mockito.when(repairGuideService.getAllRepairGuides()).thenReturn(repairGuides);

        mockMvc.perform(get("/repair-guides"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Engine Repair"));
    }

    @Test
    public void getRepairGuideByIdTest() throws Exception {
        RepairGuide repairGuide = new RepairGuide(1L, "Engine Repair", "Engine repair details");

        Mockito.when(repairGuideService.getRepairGuideById(anyLong())).thenReturn(Optional.of(repairGuide));

        mockMvc.perform(get("/repair-guides/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Engine Repair"));
    }

    @Test
    public void updateRepairGuideTest() throws Exception {
        RepairGuide updatedRepairGuide = new RepairGuide(1L, "Updated Engine Repair", "Updated details");

        Mockito.when(repairGuideService.updateRepairGuide(anyLong(), any(RepairGuide.class))).thenReturn(updatedRepairGuide);

        mockMvc.perform(put("/repair-guides/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedRepairGuide)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Engine Repair"));
    }


        // Diagnostic Tests
        @Test
        public void createDiagnosticTest() throws Exception {
        Diagnostic diagnostic = new Diagnostic(1L, "Engine Overheating", "Details about engine overheating diagnostics");

        Mockito.when(diagnosticService.createDiagnostic(any(Diagnostic.class))).thenReturn(diagnostic);

        mockMvc.perform(post("/diagnostic")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(diagnostic)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Engine Overheating"));
        }

        @Test
        public void getAllDiagnosticsTest() throws Exception {
        List<Diagnostic> diagnostics = Arrays.asList(
                new Diagnostic(1L, "Engine Overheating", "Details about engine overheating diagnostics"),
                new Diagnostic(2L, "Brake Failure", "Details about brake failure diagnostics")
        );

        Mockito.when(diagnosticService.getAllDiagnostics()).thenReturn(diagnostics);

        mockMvc.perform(get("/diagnostic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Engine Overheating"));
        }

        @Test
        public void getDiagnosticByIdTest() throws Exception {
        Diagnostic diagnostic = new Diagnostic(1L, "Engine Overheating", "Details about engine overheating diagnostics");

        Mockito.when(diagnosticService.getDiagnosticById(anyLong())).thenReturn(Optional.of(diagnostic));

        mockMvc.perform(get("/diagnostic/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Engine Overheating"));
        }



        // Maintenance Tests
        @Test
        public void createMaintenanceTest() throws Exception {
        Maintenance maintenance = new Maintenance(1L, "Engine Oil Change", "Details about the engine oil change");

        Mockito.when(maintenanceService.createMaintenance(any(Maintenance.class))).thenReturn(maintenance);

        mockMvc.perform(post("/maintenances")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(maintenance)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Engine Oil Change"));
        }

        @Test
        public void getAllMaintenancesTest() throws Exception {
        List<Maintenance> maintenances = Arrays.asList(
                new Maintenance(1L, "Engine Oil Change", "Details about the engine oil change"),
                new Maintenance(2L, "Brake Pad Replacement", "Details about brake pad replacement")
        );

        Mockito.when(maintenanceService.getAllMaintenances()).thenReturn(maintenances);

        mockMvc.perform(get("/maintenances"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Engine Oil Change"));
        }

        @Test
        public void getMaintenanceByIdTest() throws Exception {
        Maintenance maintenance = new Maintenance(1L, "Engine Oil Change", "Details about the engine oil change");

        Mockito.when(maintenanceService.getMaintenanceById(anyLong())).thenReturn(Optional.of(maintenance));

        mockMvc.perform(get("/maintenances/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Engine Oil Change"));
        }


        
        @Test
        public void createForumPostTest() throws Exception {
                Forum forum = new Forum(1L, "Brakes Issue", "Details about brakes issue");

                Mockito.when(forumService.createForumPost(any(Forum.class))).thenReturn(forum);

                mockMvc.perform(post("/forums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(forum)))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.title").value("Brakes Issue"));
        }

        @Test
        public void getAllForumPostsTest() throws Exception {
                List<Forum> forumPosts = Arrays.asList(
                        new Forum(1L, "Brakes Issue", "Details about brakes issue"),
                        new Forum(2L, "Engine Overheating", "Engine overheating details")
                );

                Mockito.when(forumService.getAllForumPosts()).thenReturn(forumPosts);

                mockMvc.perform(get("/forums"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.length()").value(2))
                        .andExpect(jsonPath("$[0].title").value("Brakes Issue"));
        }

        @Test
        public void getForumPostByIdTest() throws Exception {
                Forum forum = new Forum(1L, "Brakes Issue", "Details about brakes issue");

                Mockito.when(forumService.getForumPostById(anyLong())).thenReturn(Optional.of(forum));

                mockMvc.perform(get("/forums/{id}", 1L))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.title").value("Brakes Issue"));
        }

        

        @Test
        public void deleteForumPostTest() throws Exception {
                Mockito.doNothing().when(forumService).deleteForumPost(anyLong());

                mockMvc.perform(MockMvcRequestBuilders.delete("/forums/{id}", 1L))
                        .andExpect(status().isNoContent());
        }
}
