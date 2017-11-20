package com.helmo.NatAdmin.models;

import java.util.Date;

public class Notification  extends Identifiable{
    private String caption;
    private String description;
    private Date date;
    private boolean status;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean ok) {
        status = ok;
    }
}
