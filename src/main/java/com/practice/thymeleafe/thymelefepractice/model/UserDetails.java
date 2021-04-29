package com.practice.thymeleafe.thymelefepractice.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDetails {

    private static final String PASS_REG = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    @NotBlank(message = "Cannot have blank username!!")
    @Size(min = 3, max = 12, message = "username must be 3 to 12 characters long")
    private String userId;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email Address.")
    private String email;

    @Email(regexp = PASS_REG, message = "Invalid password")
    @Size(min = 8, max = 20, message = "password must be 8 to 20 characters long")
    private String password;

    @AssertTrue(message = "Please accept the Agreement!")
    private boolean agreement;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return "UserDetails [agreement=" + agreement + ", email=" + email + ", passsword=" + password + ", userId="
                + userId + "]";
    }

}