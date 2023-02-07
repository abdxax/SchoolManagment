package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.TeacherSerives;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherSerives teacherSerives;
    @GetMapping("/getAllTeacher")
    public List<Teacher> getAll(){
        return teacherSerives.getAll();
    }
    @PostMapping("/addTeacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherSerives.addTeacher(teacher);
       return ResponseEntity.status(200).body("Add Done");
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        Boolean res=teacherSerives.updateTeacher(id,teacher);
        if(!res){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body("Upadte done");
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        Boolean res=teacherSerives.deleteTeacher(id);
        if(!res){
            return ResponseEntity.status(400).body("The id is not correct ");
        }
        return ResponseEntity.status(200).body("delete done");
    }
    @PutMapping("{teacherId}/subject/{subjectId}")
    public ResponseEntity assignTeacher(@PathVariable Integer teacherId,@PathVariable Integer subjectId){
        Boolean res=teacherSerives.assingSubjectToTeacher(teacherId,subjectId);
        if(!res){
            return ResponseEntity.status(400).body("The Id is not correct ");
        }
        return ResponseEntity.status(200).body("assign is done");
    }
    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        Teacher teacher=teacherSerives.teacher(id);
        return ResponseEntity.status(200).body(teacher);
    }

}
