package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.repositry.TeacherRespoitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherSerives {
    private final TeacherRespoitry teacherRespoitry;

    public List<Teacher> getAll(){
        return teacherRespoitry.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRespoitry.save(teacher);
    }

    public Boolean updateTeacher(Integer id,Teacher teacher){
        Teacher t=teacherRespoitry.findByIdEquals(id);
        if(t==null){
            return false;
        }
        teacher.setId(t.getId());
        teacherRespoitry.save(teacher);
        return true;
    }
    public Boolean deleteTeacher(Integer id){
        Teacher t=teacherRespoitry.findByIdEquals(id);
        if(t==null){
            return false;
        }

        teacherRespoitry.delete(t);
        return true;
    }

}
