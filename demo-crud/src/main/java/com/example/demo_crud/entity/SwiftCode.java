package com.example.demo_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DM_SWIFT_CODE")
public class SwiftCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SWIFT_CODE")
    private String swiftCode;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;
}
