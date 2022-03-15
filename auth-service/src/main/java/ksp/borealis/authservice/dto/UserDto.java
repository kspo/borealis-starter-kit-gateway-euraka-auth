package ksp.borealis.authservice.dto;

import ksp.borealis.authservice.entity.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
public class UserDto {

    private Long id;
    private Long countryCode;
    private String mobileNumber;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Long exchangeId;
    private Date dob;
    private String nationalIdNumber;
    private String referenceCode;
    private String nationality;
    private Collection<Role> role = new ArrayList<>();

}

