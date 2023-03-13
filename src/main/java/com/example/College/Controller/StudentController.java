package com.example.College.Controller;

import com.example.College.DTO.StudentEntryDTO;
import com.example.College.Model.Student;
import com.example.College.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String > addStudent(@RequestBody StudentEntryDTO studentEntryDTO) {
        String response = studentService.addStudent(studentEntryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Integer>> findStudents(@RequestParam("year") int year){
        return new ResponseEntity<>(studentService.findStudents(year), HttpStatus.OK);
    }
}
