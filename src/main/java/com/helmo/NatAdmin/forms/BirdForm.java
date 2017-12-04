package com.helmo.NatAdmin.forms;

import javax.validation.constraints.NotNull;

public class BirdForm
{
    @NotNull
    private String name;
    @NotNull
    private String description;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
