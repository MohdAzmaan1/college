package com.example.College.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "granted")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private int amount;

    @OneToOne
    @JoinColumn
    private Branch branch;
}
