package com.example.College.Controller;

import com.example.College.Model.Branch;
import com.example.College.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<String> addBranch(@RequestBody Branch branch) {
        String response = branchService.addBranch(branch);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<String> findList() {
        String response = branchService.findList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
