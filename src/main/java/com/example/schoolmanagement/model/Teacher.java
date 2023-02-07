package com.example.schoolmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The Name can not be empty or null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @NotEmpty(message = "The Email can not be empty or null")
    @Column(columnDefinition = "varchar(150) not null")
    @Email
    private String email;
    @NotNull(message = "The age must be not null")
    @Min(18)
    private Integer age;

    private String salary;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private List<Subject> subjectSet;

}
