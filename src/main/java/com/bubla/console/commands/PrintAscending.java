package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.ArrayList;

public class PrintAscending extends PrimeCommand<String>{
    public PrintAscending(){super("print_ascending : вывести элементы коллекции в порядке возрастания");}


    @Override
    public void execute(String args, Application application) {
        ArrayList<Product> val = application.getProducts().sort();
        for (Product prod:
             val) {
            System.out.println(prod);
        }
        this.setApplication(application);
    }
}
