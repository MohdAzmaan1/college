package com.example.College.Service;

import com.example.College.DTO.StudentEntryDTO;
import com.example.College.Model.Branch;
import com.example.College.Model.Student;
import com.example.College.Repository.BranchRepository;
import com.example.College.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BranchRepository branchRepository;

    public String addStudent(StudentEntryDTO studentEntryDTO) {
        Student student = new Student();
        student.setName(studentEntryDTO.getName());
        student.setBranchName(studentEntryDTO.getBranchName());
        student.setMarks(studentEntryDTO.getMarks());
        student.setAdmissionYear(studentEntryDTO.getAdmissionYear());
        Branch branch = branchRepository.findById(studentEntryDTO.getBranchId()).get();

        student.setBranch(branch);
        studentRepository.save(student);

        return "Student Added";
    }

    public List<Integer> findStudents(int year) {
        List<Student> list1 = studentRepository.findAll();
        List<Integer> ans = new ArrayList<>();
        for(Student student : list1) {
            if(student.getAdmissionYear() == year)
                ans.add(student.getId());
        }
        return ans;
    }
}
