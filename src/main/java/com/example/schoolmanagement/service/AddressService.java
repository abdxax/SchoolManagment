package com.example.schoolmanagement.service;

import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.handking.ApiException;
import com.example.schoolmanagement.model.Address;
import com.example.schoolmanagement.model.Teacher;

import com.example.schoolmanagement.repositry.AddressRepsitory;
import com.example.schoolmanagement.repositry.TeacherRespoitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepsitory address;
    private final TeacherRespoitry teacherRespoitry;

    public List<Address> getAll(){
        return address.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRespoitry.findByIdEquals(addressDTO.getId());
        if(teacher==null){
            throw  new ApiException("The Id can not foun Teacher ");
        }
        Address address1=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        address.save(address1);

    }

    public Boolean update (Integer id,AddressDTO addressDTO){
        Teacher teacher=teacherRespoitry.findByIdEquals(id);
        if(teacher==null){
            return false;
        }
        Address address1=address.findByIdEquals(id);
        if(address1==null){
            return false;
        }
        address1.setArea(addressDTO.getArea());
        address1.setStreet(addressDTO.getStreet());
        address1.setBuildingNumber(addressDTO.getBuildingNumber());
        address.save(address1);
        return true;


    }

    public Boolean delete (Integer id){
        Teacher teacher=teacherRespoitry.findByIdEquals(id);
        if(teacher==null){
            return false;
        }
        Address address1=address.findByIdEquals(id);
        if(address1==null){
            return false;
        }

        address.delete(address1);
        return true;


    }

    public Address findAddress(Integer id){
        return address.findByIdEquals(id);
    }





}

