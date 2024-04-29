package com.bubla.classes;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class Person implements Comparable<Person>{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDateTime birthday; //Поле может быть null
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0

    public Person(String name, String birthday, Long weight){
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.birthday = LocalDateTime.parse(birthday, formatter);
        this.weight = weight;
    }
    public Person(String name, LocalDateTime birthday, Long weight){
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
    }
    public Person(String name, Long weight){
        this(name, LocalDateTime.now(), weight);
    }
    public Person(){}
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
        if(birthday != "") {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            this.birthday = LocalDateTime.parse(birthday, formatter);
        }
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
