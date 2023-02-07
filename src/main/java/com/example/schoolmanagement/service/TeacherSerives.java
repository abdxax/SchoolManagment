package com.example.schoolmanagement.service;

import com.example.schoolmanagement.handking.ApiException;
import com.example.schoolmanagement.model.Subject;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.repositry.SubjectResptory;
import com.example.schoolmanagement.repositry.TeacherRespoitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherSerives {
    private final TeacherRespoitry teacherRespoitry;
    private final SubjectResptory subjectResptory;

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

    public Boolean assingSubjectToTeacher(Integer teacherId,Integer subjectId){
        Teacher teacher=teacherRespoitry.findByIdEquals(teacherId);
        Subject subject=subjectResptory.findByIdEquals(subjectId);
        if(teacher==null||subject==null){
            return null;
        }
        subject.setTeacher(teacher);
        subjectResptory.save(subject);
       // teacher.setSubjectSet(subjectSet(teacherId));
        //teacherRespoitry.save(teacher);
        return true;
    }



    public Teacher teacher(Integer id){
        Teacher teacher=teacherRespoitry.findByIdEquals(id);
        if(teacher==null){
            throw new ApiException("The Id is not correct ");
        }
        return teacher;
    }

}
