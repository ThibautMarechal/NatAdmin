package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

public abstract class IdentifiedModel {
    
    @Getter @Setter
    private long id;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdentifiedModel)) return false;
        IdentifiedModel that = (IdentifiedModel) o;
        
        return id == that.id;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}