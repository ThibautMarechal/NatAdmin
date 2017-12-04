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

}
