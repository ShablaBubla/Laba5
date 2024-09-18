package com.bubla.classes;

import com.bubla.console.exceptions.WrongCommandFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;


public class Product implements Comparable<Product>{
    static long lastId = 0;
    @Getter
    private long id;//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Getter
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Getter
    private Coordinates coordinates; //Поле не может быть null
    @Getter
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Getter
    private long price; //Значение поля должно быть больше 0
    @Getter
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    @Getter
    @Setter
    private Person owner; //Поле может быть null

    public Product(long id, String name, Coordinates coordinates, Date creationDate, long price, UnitOfMeasure unitOfMeasure, Person owner){
        this.creationDate = creationDate;
        this.lastId = Math.max(id, lastId);
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    public Product(String name, Coordinates coordinates, long price, UnitOfMeasure unitOfMeasure, Person owner){
        this.creationDate = new Date();
        this.lastId += 1;
        this.id = this.lastId;
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    public Product(String name, Coordinates coordinates, long price, UnitOfMeasure unitOfMeasure){
        this(name, coordinates, price, unitOfMeasure, null);
    }
    public Product(){
        this.creationDate = new Date();
        this.lastId += 1;
        this.id = this.lastId;
    }
    public void setName(String newName) {
        if(newName == null){
            throw new IllegalArgumentException("name cannot be null");
        }
        if(newName.equals("")){
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = newName;
    }
    public void setCoordinates(Coordinates newCoordinates){
        if(newCoordinates == null){
            throw new IllegalArgumentException("coordinates cannot be null");
        }
        this.coordinates = newCoordinates;
    }
    public void setPrice(long newPrice){
        if(newPrice <= 0){
            throw new IllegalArgumentException("price can be only positive");
        }
        this.price = newPrice;
    }
    public void setUnitOfMeasure(UnitOfMeasure newUnit){
        if(newUnit == null){
            throw new IllegalArgumentException("unitOfMeasure cannot be null");
        }
        this.unitOfMeasure = newUnit;
    }



    @Override
    public String toString(){return "id " + this.id + ", " + this.name + " " + this.price + " за " + this.unitOfMeasure + ", лежит в " + this.getCoordinates() +", владелец: " + this.owner;}


    @Override
    public int compareTo(Product prod) {
        return this.name.compareTo(prod.getName());
    }

    public void enterProd(){
        Scanner sc = new Scanner(System.in);
        Coordinates coord = new Coordinates();
        Person owner = new Person();
        boolean hasOwner = true;
        boolean correct = false;
        System.out.println("Введите название продукта");
        while (!correct) {
            try {
                this.setName(sc.next());
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Введите название продукта ещё раз");
            }
        }
        correct = false;
        System.out.println("Введите координату x продукта");
        while (!correct) {
            try {
                coord.setX(Float.valueOf(sc.next()));
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Введите координату x продукта ещё раз");
            }
        }
        correct = false;
        System.out.println("Введите координату y продукта");
        while (!correct) {
            try {
                coord.setY(Integer.valueOf(sc.next()));
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Введите координату y ещё раз");
            }
        }
        correct = false;
        this.setCoordinates(coord);
        System.out.println("Введите цену продукта");
        while (!correct) {
            try {
                this.setPrice(Long.parseLong(sc.next()));
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Введите цену продукта ещё раз");
            }
        }
        correct = false;
        System.out.println("Введите меру измерения продукта");
        System.out.println("Сантиметр Грамм Милиграмм");
        while (!correct) {
            try {
                UnitOfMeasure unitOfMeasure = switch (sc.next()) {
                    case "Сантиметр" -> UnitOfMeasure.CENTIMETERS;
                    case "Грамм" -> UnitOfMeasure.GRAMS;
                    case "Милиграмм" -> UnitOfMeasure.MILLIGRAMS;
                    default -> throw new WrongCommandFormat("не та мера измерения");
                };
                this.setUnitOfMeasure(unitOfMeasure);
                correct = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Введите меру измерения продукта ещё раз");
            }
        }
        correct = false;
        System.out.println("У продукта есть владелец?д/Н");
        while (!correct) {
            try {
                hasOwner = switch (sc.next()) {
                    case "д" -> true;
                    case "Н" -> false;
                    default -> throw new WrongCommandFormat("строка должна содержать только д/Н");
                };
                correct =true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        correct = false;
        if (hasOwner) {
            System.out.println("Введите имя владельца продукта");
            while (!correct) {
                try {
                    owner.setName(sc.next());
                    correct = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Введите имя владельца продукта ещё раз");
                }
            }
            correct = false;
            System.out.println("Введите дату рождения владельца в формате 'гггг-мм-дд'");
            String birthday = sc.next();
            if ("".equals(birthday)){
            } else {
                while (!correct) {
                    try {
                        owner.setBirhday(birthday);
                        correct = true;
                    } catch (Exception e) {
                        System.out.println("Неверный формат " + e.getMessage());
                        System.out.println("Введите дату рождения владельца продукта ещё раз");
                        birthday = sc.next();
                    }
                }
                correct = false;
            }
            System.out.println("Введите вес владельца продукта");
            while (!correct) {
                try {
                    owner.setWeight(Long.valueOf(sc.next()));
                    correct = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Введите вес владельца продукта ещё раз");
                }
            }
            this.setOwner(owner);
        }
    }
}

