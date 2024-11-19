package com.example.demo_crud.controller;

import com.example.demo_crud.service.impl.SwiftCodeSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ScheduerController {

    @Autowired
    private SwiftCodeSyncService swiftCodeSyncService;

    @PostMapping("/start")
    public ResponseEntity<String> manualSync() {
        swiftCodeSyncService.syncSwiftCodes();
        return ResponseEntity.ok("Synchronization started manually.");
    }
}
