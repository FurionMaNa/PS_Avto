package com.market.ps_avto;

public class ParamsClass {
    private Boolean select;
    private String name;
    private Integer type;

    public ParamsClass(Boolean select, String name, Integer type) {
        this.select = select;
        this.name = name;
        this.type = type;
    }

    public Boolean getSelect() {
        return select;
    }

    public void setSelect(Boolean select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
