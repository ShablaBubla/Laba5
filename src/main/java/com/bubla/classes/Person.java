package com.bubla.classes;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person>{
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="birthday")
    private LocalDateTime birthday; //Поле может быть null
    @XmlElement(name="weight")
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0

    public Person(String name, String birthday, Long weight){
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.birthday = LocalDateTime.parse(birthday, formatter);
        this.weight = weight;
    }
    public Person(String name, Long weight){
        this(name, null, weight);
    }
    public Person(){
        this(null, null, null);
    }
    public void setName(String newName){
        if(newName == null){
            throw new IllegalArgumentException("name cannot be null");
        }
        if(newName.equals("")){
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = newName;
    }
    public void setBirhday(String birthday){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.birthday = LocalDateTime.parse(birthday, formatter);
    }
    public void setWeight(Long newWeight){
        if(newWeight == null){
            throw new IllegalArgumentException("weight cannot be null");
        }
        if(newWeight <= 0){
            throw new IllegalArgumentException("weight cannot be negative");
        }
        this.weight = newWeight;
    }

    @Override
    public int compareTo(Person pers) {
        return this.name.compareTo(pers.getName());
    }
}
