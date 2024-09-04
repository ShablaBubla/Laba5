package com.bubla.classes;

import lombok.Data;


@Data
public class Coordinates {
    private Float x; //Поле не может быть null
    private Integer y; //Значение поля должно быть больше -837, Поле не может быть null

    public Coordinates(Float x, Integer y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){}

    public void setX(Float newX){
        if(newX == null){
            throw new IllegalArgumentException("x cannot be null");
        }
        this.x = newX;
    }
    public void setY(Integer newY){
        if(newY == null){
            throw new IllegalArgumentException("y cannot be null");
        }
        if(newY <= -837){
            throw new IllegalArgumentException("y cannot be below -837");
        }
        this.y = newY;
    }
    @Override
    public String toString(){return "x: " + x + ", y: " + y;}
}
