package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Dictionary;
import java.util.List;

@Getter
@Setter
public class Bird  extends Identifiable{
    private String name;
    private String description;
    private Dictionary<String, List<String>> attribute;
}
