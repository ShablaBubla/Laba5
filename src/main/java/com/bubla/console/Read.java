package com.bubla.console;

import com.bubla.classes.Product;
import jakarta.xml.bind.*;
import lombok.Data;

import java.io.*;
import java.util.stream.Collectors;


public class Read {
    private FileReader fileReader;
    private File file;
    private Product product;

    public Read(String uml){
        try{
            this.file = new File(uml);
            this.fileReader = new FileReader(file);
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            this.product = (Product) unmarshaller.unmarshal(fileReader);
        } catch (FileNotFoundException e){
            System.out.println("хуй");
        } catch (JAXBException e){
            System.out.println(e.getMessage());
        }
    }

    public Product getProduct(){
        return this.product;
    }
}
