package com.prjgrp.artf.controller;

import com.prjgrp.artf.entity.Diagnostic;
import com.prjgrp.artf.service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diagnostic")
public class DiagnosticController {

    @Autowired
    private DiagnosticService diagnosticService;

    @PostMapping
    public ResponseEntity<Diagnostic> createDiagnostic(@RequestBody Diagnostic diagnostic) {
        Diagnostic createdDiagnostic = diagnosticService.createDiagnostic(diagnostic);
        return new ResponseEntity<>(createdDiagnostic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Diagnostic>> getAllDiagnostics() {
        List<Diagnostic> diagnostics = diagnosticService.getAllDiagnostics();
        return ResponseEntity.ok(diagnostics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostic> getDiagnosticById(@PathVariable Long id) {
        Optional<Diagnostic> diagnostic = diagnosticService.getDiagnosticById(id);
        return diagnostic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnostic(@PathVariable Long id) {
        diagnosticService.deleteDiagnostic(id);
        return ResponseEntity.noContent().build();
    }
}
