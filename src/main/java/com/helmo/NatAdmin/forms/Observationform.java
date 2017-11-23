package com.helmo.NatAdmin.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Observationform
{
    @NotNull
    @Min(1)
    private int birdNumber;

    @NotNull
    @Min(0)
    private int heigth;

    public int getBirdNumber()
    {
        return birdNumber;
    }

    public void setBirdNumber(int birdNumber)
    {
        this.birdNumber = birdNumber;
    }

    public int getHeigth()
    {
        return heigth;
    }

    public void setHeigth(int heigth)
    {
        this.heigth = heigth;
    }
}
