package com.example.demo_crud.service.impl;

import com.example.demo_crud.repository.SwiftCodeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiftCodeSyncService {

    @Autowired
    private SwiftCodeRepository swiftCodeRepository;

    @Transactional
    public void syncSwiftCodes() {
        // Lấy danh sách từ MIS
    }
}
