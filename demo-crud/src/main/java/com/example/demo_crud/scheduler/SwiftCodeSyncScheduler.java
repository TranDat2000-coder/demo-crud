package com.example.demo_crud.scheduler;

import com.example.demo_crud.service.impl.SwiftCodeSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SwiftCodeSyncScheduler {

    @Autowired
    private SwiftCodeSyncService swiftCodeSyncService;

    @Scheduled(cron = "0 0 0 1 1 *")
    public void swiftCodeSync() {
        swiftCodeSyncService.syncSwiftCodes();
    }
}
