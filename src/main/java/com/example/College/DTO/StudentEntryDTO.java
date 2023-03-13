package com.example.College.DTO;

import com.example.College.Model.BranchName;
import lombok.Data;

@Data
public class StudentEntryDTO {

    private String name;

    private BranchName branchName;

    private int marks;

    private int branchId;

    private int admissionYear;
}
