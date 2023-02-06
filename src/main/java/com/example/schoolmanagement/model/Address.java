package com.example.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(50) not null")
    private String area;
    @Column(columnDefinition = "varchar(50) not null")
    private String street;
    @Column(columnDefinition = "varchar(50) not null")
    private String buildingNumber;



    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
