package com.helmo.NatAdmin.models;


import java.util.Date;

public class Observation  extends Identifiable{
    private Date date;
    private String latitude;
    private String longitude;
    private int numberOfBird;
    private boolean isValid;
    private Bird bird;
    private String mediaType;
    private String mediaPath;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getNumberOfBird() {
        return numberOfBird;
    }

    public void setNumberOfBird(int numberOfBird) {
        this.numberOfBird = numberOfBird;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }
}
