package com.example.demo_crud.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwiftCodeDTO {

    private String swiftCode;

    private String nameBank;

    private String note;
}
