package com.example.schoolmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @NotEmpty(message = "the majer can not null")
    @Column(columnDefinition = "varchar(50) not null")
    private String major;
    private Integer age;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private List<Subject> subjectSet;

}
