package com.bubla.console.commands;

import java.util.HashMap;
import java.util.Scanner;

import com.bubla.classes.*;
import com.bubla.console.exceptions.WrongCommandFormat;
import com.bubla.console.executer.Application;

public class Insert extends PrimeCommand<String> {
    public Insert(){super("insert null {element} : добавить новый элемент с заданным ключом");}

    @Override
    public void execute(String args, Application application){
        try{Product prod = new Product();
        prod.enterProd();
        LinkedHashMapOfProducts prods = application.getProducts();
        prods.add(args, prod);
        application.setProducts(prods);
        ;}
        catch (Exception e){
            System.out.println("Неверный формат ключа");
        }
        finally {
            this.setApplication(application);
        }
    }
}
