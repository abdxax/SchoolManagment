package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Subject;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    @GetMapping("/getAll")
    public List<Subject> getAll(){
        return subjectService.getAll();
    }
    @PostMapping("/addSubject")
    public ResponseEntity addTeacher(@RequestBody @Valid Subject subject){
        subjectService.addSubject(subject);
        return ResponseEntity.status(200).body("Add Done");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Subject subject){
        Boolean res=subjectService.updateSubject(id,subject);
        if(!res){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body("Upadte done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        Boolean res=subjectService.deleteSubject(id);
        if(!res){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body("delete done");
    }
    @GetMapping("/getTeacherByName/{id}")
    public ResponseEntity getTecherName(@PathVariable Integer id){
        Teacher teacher=subjectService.teacher(id);
        return ResponseEntity.status(200).body(teacher.getName());
    }
}
