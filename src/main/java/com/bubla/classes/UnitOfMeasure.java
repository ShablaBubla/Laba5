package com.bubla.classes;



public enum UnitOfMeasure {
    CENTIMETERS("Centimeters"),
    GRAMS("Grams"),
    MILLIGRAMS("Miligrams");
    private String desc;
    UnitOfMeasure(String desc){
        this.desc = desc;
    }

    @Override
    public String toString(){return desc;}

}
