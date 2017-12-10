package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Bird  extends Identifiable{
    private String name;
    private String description;
    private Map<String, List<String>> attributes;
    private List<String> pictures;
}
