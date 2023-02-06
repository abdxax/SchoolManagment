package com.example.schoolmanagement.repositry;

import com.example.schoolmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRespoitry extends JpaRepository<Teacher,Integer> {
    Teacher findByIdEquals(Integer id);
}
