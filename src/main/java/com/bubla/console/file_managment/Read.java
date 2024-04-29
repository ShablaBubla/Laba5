package com.bubla.console.file_managment;

import com.bubla.classes.Product;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Read {
    File file;
    List<Product> products;

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
            XmlMapper xmlMapper = new XmlMapper();
            @Data
            class ArrayOfProducts{
                List<Product> products=new ArrayList<>();
            }
            ArrayOfProducts prods = xmlMapper.readValue(xml.toString(), ArrayOfProducts.class);
            this.products = prods.getProducts();
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IOException e) {
            System.out.println("Невозможно прочесть");
        }
    }
}
