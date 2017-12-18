package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Attribute extends IdentifiedModel
{
    public String key;
    public List<String> values;
}
