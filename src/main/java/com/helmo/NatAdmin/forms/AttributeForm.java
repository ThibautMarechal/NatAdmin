package com.helmo.NatAdmin.forms;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AttributeForm
{
    @NotNull
    private List<String> values;
    @NotNull
    private String key;

    public List<String> getValues()
    {
        return values;
    }

    public void setValues(List<String> values)
    {
        this.values = values;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
