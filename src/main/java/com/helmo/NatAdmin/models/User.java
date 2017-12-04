package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Identifiable
{
    private String fullName;
    private String email;
    private boolean isAdmin;
    private String profilePictureUrl;
}
