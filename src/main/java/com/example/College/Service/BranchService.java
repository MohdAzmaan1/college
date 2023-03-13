package com.example.College.Service;

import com.example.College.Model.Branch;
import com.example.College.Model.Student;
import com.example.College.Repository.BranchRepository;
import com.example.College.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    StudentRepository studentRepository;

    public String addBranch(@RequestBody Branch branch) {
        branchRepository.save(branch);
        return "Branch Added";
    }

    public String findList() {
        List<Student> list = studentRepository.findAll();
        int pass = 40;
        String hod = "";
        Map<String ,Integer> map = new HashMap<>();
        for(Student student : list) {
            if(student.getMarks() > pass){
                hod = student.getBranch().getContactNumber();
                map.put(hod, map.getOrDefault(hod, 0) + 1);
            }
        }
        String ans = "";
        int a = 0;
        for(String str : map.keySet()) {
            if(map.get(str) > a){
                ans = str;
                a = map.get(str);
            }
        }
        return ans;
    }
}
