package com.example.schoolmanagement.service;

import com.example.schoolmanagement.handking.ApiException;
import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.model.Subject;
import com.example.schoolmanagement.repositry.StudentRespotry;
import com.example.schoolmanagement.repositry.SubjectResptory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private  final StudentRespotry studentRespotry;
    private final SubjectResptory subjectResptory;
    public List<Student> getAll(){
        return studentRespotry.findAll();
    }
    public void addStudent(Student student){
        studentRespotry.save(student);
    }

    public Boolean uodate(Integer id,Student student){
        Student s=studentRespotry.findByIdEquals(id);
        if(s==null){
            return null;
        }
        student.setId(s.getId());
        studentRespotry.save(student);
        return true;
    }

    public Boolean delete(Integer id){
        Student s=studentRespotry.findByIdEquals(id);
        if(s==null){
            return null;
        }

        studentRespotry.delete(s);
        return true;
    }

    public void assignStudenttoSubject(Integer subjectId,Integer studentId){
        Student student=studentRespotry.findByIdEquals(studentId);
        Subject subject=subjectResptory.findByIdEquals(subjectId);
        if(student==null||subject==null){
            throw new ApiException("the id is not correct");
        }
        student.getSubjectSet().add(subject);
        subject.getStudents().add(student);
        studentRespotry.save(student);
        subjectResptory.save(subject);

    }

    public Boolean updatemajer(Integer id,String majer){
        Student s=studentRespotry.findByIdEquals(id);
        if(s==null){
            return false;
        }
        s.setMajor(majer);

        studentRespotry.save(s);
       // studentRespotry.deleteBySubjectSet(s);
        //s.se
        return true;
    }

}
