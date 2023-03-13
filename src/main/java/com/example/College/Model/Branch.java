package com.example.College.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private String hodName;

    private String contactNumber;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();
}
