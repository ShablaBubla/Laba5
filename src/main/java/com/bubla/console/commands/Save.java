package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;
import com.bubla.console.file_managment.Write;

import java.io.*;

public class Save extends PrimeCommand<String>{
    public Save(){super("save : сохранить коллекцию в файл");}

    @Override
    public void execute(String args, Application application){
        try {
            Product[] products = new Product[application.getProducts().getSize()];
            int i = 0;
            for(Product value: application.getProducts().getProducts().values()){
                products[i] = value;
                i++;
            }
            Write write = new Write(products);
            write.record(new File(System.getenv("FILE_PATH")));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            this.setApplication(application);
        }
    }
}
