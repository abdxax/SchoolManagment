package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Added Done");
    }
    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Student student){
        Boolean s=studentService.uodate(id,student);
        if(!s){
            return ResponseEntity.status(400).body("The Id is not correct");
        }
        return ResponseEntity.status(200).body("Update done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable Integer id){
        Boolean s=studentService.delete(id);
        if(!s){
            return ResponseEntity.status(400).body("The Id is not correct");
        }
        return ResponseEntity.status(200).body("delete done");
    }
    @PutMapping("/{subId}/student/{stuId}")
    public ResponseEntity assign(@PathVariable Integer subId,@PathVariable Integer stuId){
        studentService.assignStudenttoSubject(subId,stuId);
        return ResponseEntity.status(200).body("The assign done");
    }

    @PutMapping("/updateMajer/{id}")
    public ResponseEntity updateMajer(@PathVariable Integer id,@RequestBody String majer){
        Boolean res=studentService.updatemajer(id,majer);
        if(!res){
           return ResponseEntity.status(400).body("The Id student is not correct ");

        }
        return ResponseEntity.status(200).body("The update is done");
    }
}
