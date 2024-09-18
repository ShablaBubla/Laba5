package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Person;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.HashSet;

public class PrintUniqueOwner extends PrimeCommand<String> {
    public PrintUniqueOwner(){super("print_unique_owner : вывести уникальные значения поля owner всех элементов в коллекции");}

    @Override
    public void execute(String args, Application application) {
        LinkedHashMapOfProducts products = application.getProducts();
        HashSet<Person> owners = new HashSet<>();
        for (Product prod:
                products.getProducts().values()) {
            Person owner = prod.getOwner();
            try {
                if (!owners.contains(owner) & owner != null) {
                    System.out.println(owner);
                }
                owners.add(owner);
            } catch (NullPointerException e){
                System.out.print("");
            }
        }
    }
}
