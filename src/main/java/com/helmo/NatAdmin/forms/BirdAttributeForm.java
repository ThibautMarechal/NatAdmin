package com.helmo.NatAdmin.forms;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirdAttributeForm
{
    @NotNull
    private Map<String, List<String>> attributes;

    public Map<String, List<String>> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, List<String>> attributes)
    {
        this.attributes = attributes;
    }

    public static BirdAttributeForm ParseJSON(String source){
        Map<String, List<String>> attributes = new HashMap<>();
        JSONParser parser = new JSONParser();
        try
        {
            Object obj = parser.parse(source);
            JSONObject jsonObject =  (JSONObject) obj;
        }
        catch (ParseException e)
        {
            return null;
        }
        BirdAttributeForm baf = new BirdAttributeForm();
        return baf;
    }
}
