package com.helmo.NatAdmin.models;

import java.util.Date;
import java.util.List;

public class Session  extends Identifiable{
    private User user;
    private String name;
    private Date start;
    private Date end;
    private String latitude;
    private String longitude;
    private List<Observation> observations;
    private String location;

    public User getUser() {
        return user;
    }

    public void setUser(User owner) {
        this.user = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
        this.location = String.format("%s - %s", longitude, latitude);
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
        this.location = String.format("%s - %s", longitude, latitude);
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public String getLocation(){
        return location;
    }
}
