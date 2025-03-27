package com.prjgrp.artf.repository;

import com.prjgrp.artf.entity.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {
    // JpaRepository provides findById and other CRUD operations
}
