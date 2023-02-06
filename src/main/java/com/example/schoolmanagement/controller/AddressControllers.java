package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.model.Address;
import com.example.schoolmanagement.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressControllers {
    private final AddressService addressService;

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return addressService.getAll();
    }
    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
      return   ResponseEntity.status(200).body("Add Address Done");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid AddressDTO addressDTO){
        Boolean res=addressService.update(id,addressDTO);
        if(!res){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Done update");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean res=addressService.delete(id);
        if(!res){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Done update");
    }
    @GetMapping("/getAddress/{id}")
    public ResponseEntity getAddress(@PathVariable Integer id){
        Address address=addressService.findAddress(id);
        if(address==null){
            return ResponseEntity.status(200).body("The id is not correct");
        }
        return ResponseEntity.status(200).body(address);
    }
}
