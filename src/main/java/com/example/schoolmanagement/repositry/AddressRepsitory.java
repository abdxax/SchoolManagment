package com.example.schoolmanagement.repositry;

import com.example.schoolmanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepsitory extends JpaRepository<Address,Integer> {
    Address findByIdEquals(Integer id);
}
