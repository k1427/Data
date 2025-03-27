package com.prjgrp.artf.service;

import com.prjgrp.artf.entity.Diagnostic;
import com.prjgrp.artf.repository.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticService {

    @Autowired
    private DiagnosticRepository diagnosticRepository;

    public Diagnostic createDiagnostic(Diagnostic diagnostic) {
        return diagnosticRepository.save(diagnostic);
    }

    public List<Diagnostic> getAllDiagnostics() {
        return diagnosticRepository.findAll();
    }

    public Optional<Diagnostic> getDiagnosticById(Long id) {
        return diagnosticRepository.findById(id);
    }

    public void deleteDiagnostic(Long id) {
        diagnosticRepository.deleteById(id);
    }
}
