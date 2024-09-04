package com.bubla.console.file_managment;

import com.bubla.classes.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;


import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Read {
    private File file;
    private LinkedHashMap<String, Product> products;

    public Read(File file){
        this.file = file;
        this.products = new LinkedHashMap<>();
    }

    public void refil() {
        try (FileReader reader = new FileReader(this.file);){
            StringBuilder xml = new StringBuilder();
            int sym;
            while((sym = reader.read())!=-1){
                xml.append((char)sym);
            }
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            LinkedHashMap mapped = xmlMapper.readValue(xml.toString(), LinkedHashMap.class);
            for(Object key: mapped.keySet()){
                LinkedHashMap newProduct = (LinkedHashMap)mapped.get(key);
                Person owner = null;
                try {
                    LinkedHashMap newOwner = (LinkedHashMap) newProduct.get("owner");
                    owner = new Person(newOwner.get("name").toString(), LocalDateTime.parse(newOwner.get("birthday").toString()), Long.parseLong(newOwner.get("weight").toString()));
                } catch (ClassCastException e){
                    System.out.print("");
                }
                LinkedHashMap newCoordinates = (LinkedHashMap) newProduct.get("coordinates");
                Coordinates coordinates = new Coordinates(Float.parseFloat(newCoordinates.get("x").toString()), Integer.parseInt(newCoordinates.get("y").toString()));
                UnitOfMeasure unitOfMeasure = switch(newProduct.get("unitOfMeasure").toString()){
                    case "CENTIMETERS" -> UnitOfMeasure.CENTIMETERS;
                    case "MILIGRAMS" -> UnitOfMeasure.MILLIGRAMS;
                    default -> UnitOfMeasure.GRAMS;
                };

                String newDate = newProduct.get("creationDate").toString();
                DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(newDate, formatter);
                Date date = Date.from(zonedDateTime.toInstant());

                Product product = new Product(Long.parseLong(newProduct.get("id").toString()), newProduct.get("name").toString(), coordinates, date, Long.parseLong(newProduct.get("price").toString()), unitOfMeasure, owner);
                this.products.put(key.toString(), product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
