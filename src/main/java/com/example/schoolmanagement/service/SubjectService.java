package com.example.schoolmanagement.service;

import com.example.schoolmanagement.handking.ApiException;
import com.example.schoolmanagement.model.Subject;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.repositry.SubjectResptory;
import com.example.schoolmanagement.repositry.TeacherRespoitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectResptory subjectResptory;
    private final TeacherRespoitry teacherRespoitry;

    public List<Subject> getAll(){
        return subjectResptory.findAll();
    }

    public void addSubject(Subject subject){
        subjectResptory.save(subject);
    }

    public Boolean updateSubject(Integer id,Subject subject){
        Subject subject1=subjectResptory.findByIdEquals(id);
        if(subject1==null){
            return false;
        }
        subject.setId(subject1.getId());
        subject.setTeacher(subject1.getTeacher());
        subjectResptory.save(subject);
        return true;
    }

    public Boolean deleteSubject(Integer id){
        Subject subject1=subjectResptory.findByIdEquals(id);
        if(subject1==null){
            return false;
        }

        subjectResptory.delete(subject1);

        return true;
    }

    public Teacher teacher(Integer courseId){
        Subject subject=subjectResptory.findByIdEquals(courseId);
        if(subject==null){
            throw  new ApiException("The id is not correct");
        }
        return teacherRespoitry.findByIdEquals(subject.getTeacher().getId());
    }




}
