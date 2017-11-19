package com.helmo.NatAdmin.models;

import java.util.Date;

public class Observation  extends Identifiable{
    private Date date;
    private String latitude;
    private String longitude;
    private int numberOfBird;
    private boolean isValid;
    private Bird bird;

}
