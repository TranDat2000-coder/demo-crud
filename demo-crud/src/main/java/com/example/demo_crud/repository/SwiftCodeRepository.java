package com.example.demo_crud.repository;

import com.example.demo_crud.entity.SwiftCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SwiftCodeRepository extends JpaRepository<SwiftCode, Long> {

    Optional<SwiftCode> findBySwiftCode(String swiftCode);
}
