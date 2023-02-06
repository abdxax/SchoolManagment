package com.example.schoolmanagement.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer id;
    @NotEmpty(message = "The Area can not be null")
    @Size(min = 3,max = 90)
    private String area;

    @NotEmpty(message = "The street can not be null")
    @Size(min = 3,max = 90)
    private String street;
    @NotEmpty(message = "The buildingNumber can not be null")
    @Size(min = 3,max = 20)
    private String buildingNumber;

}
