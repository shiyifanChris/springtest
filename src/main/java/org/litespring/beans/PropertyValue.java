package org.litespring.beans;


public class PropertyValue {

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
