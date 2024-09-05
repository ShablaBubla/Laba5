package com.bubla.console.commands;

import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.ArrayList;
import java.util.Collections;

public class PrintFieldDescendingUnitOfMeasure extends PrimeCommand<String> {
    public PrintFieldDescendingUnitOfMeasure(){super("print_field_descending_unit_of_measure : вывести значения поля unitOfMeasure всех элементов в порядке убывания");}


    @Override
    public void execute(String args, Application application) {
        ArrayList<Product> val = application.getProducts().sort();
        Collections.reverse(val);
        for (Product prod:
             val) {
            System.out.println(prod.getUnitOfMeasure());
        }
    }
}
