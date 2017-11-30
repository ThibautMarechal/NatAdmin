package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Notification extends IdentifiedModel
{
    private String caption;
    private String description;
    private Date date;
    private boolean status;
    private Observation observation;

    public String getCaption()
    {
        return caption;
    }

    public void setCaption(String caption)
    {
        this.caption = caption;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public boolean getStatus()
    {
        return status;
    }

    public void setStatus(boolean ok)
    {
        status = ok;
    }

    public Observation getObservation()
    {
        return observation;
    }

    public void setObservation(Observation observation)
    {
        this.observation = observation;
    }
}
