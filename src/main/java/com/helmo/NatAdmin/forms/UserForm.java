package com.helmo.NatAdmin.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm
{
    @NotNull
    @Size(min=1, max=50)
    private String fullName;
    @NotNull
    @Pattern(regexp="/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/")
    private String email;
    @NotNull
    private boolean isAdmin;
    @NotNull
    @Size(min=8, max=50)
    private String password;
    @NotNull
    @Size(min=8, max=50)
    private String confirmedPassword;

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmpassword()
    {
        return confirmedPassword;
    }

    public void setConfirmpassword(String confirmpassword)
    {
        this.confirmedPassword = confirmpassword;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public void setAdmin(boolean admin)
    {
        isAdmin = admin;
    }
}
