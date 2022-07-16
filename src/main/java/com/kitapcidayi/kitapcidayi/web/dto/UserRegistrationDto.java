package com.kitapcidayi.kitapcidayi.web.dto;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDto {
    @NotBlank
    @Size(min=2, max=50, message = "Firstname must be between 2-50 characters!")
    private String firstName;
    @NotBlank
    @Size(min=2, max=50, message = "Lastname must be between 2-50 characters!")
    private String lastName;
    @NotBlank
    @Email(message = "Please provide a real e-mail address!'")
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$",
            message = "Password must contain at least 1 number, 1 lowercase and uppercase Latin character. And also must be between 8-20 characters!")
    private String password;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public UserRegistrationDto(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserRegistrationDto() {
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
