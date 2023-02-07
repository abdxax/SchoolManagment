package com.example.schoolmanagement.repositry;

import com.example.schoolmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SubjectResptory extends JpaRepository<Subject,Integer> {
    Subject findByIdEquals(Integer id);
    List<Subject> findByTeacher_Id(Integer id);
}
