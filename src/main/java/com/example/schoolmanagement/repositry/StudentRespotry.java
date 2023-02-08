package com.example.schoolmanagement.repositry;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespotry extends JpaRepository<Student,Integer> {
    Student findByIdEquals(Integer id);
    List<Student> findBySubjectSet(Subject subject);
    List<Subject> deleteBySubjectSet(Student student);


}
