package com.helmo.NatAdmin.models;

import java.util.List;

public class Attribute extends Identifiable
{
    public String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> values;
}
