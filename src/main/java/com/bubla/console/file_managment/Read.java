package com.bubla.console.file_managment;

import com.bubla.classes.Product;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Read {
    File file;
    Product[] products;

    public Read(File file){
        this.file = file;
    }

    public void refil() {
        try (FileReader reader = new FileReader(this.file);){
            StringBuilder xml = new StringBuilder();
            int sym;
            while((sym= reader.read())!=-1){
                xml.append((char)sym);
            }
            XmlMapper xmlMapper = (XmlMapper) new XmlMapper().registerModule(new JavaTimeModule());
            this.products = xmlMapper.readValue(xml.toString(), Product[].class);
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
