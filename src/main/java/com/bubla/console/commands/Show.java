package com.bubla.console.commands;

import com.bubla.classes.*;
import com.bubla.console.executer.Application;

public class Show extends PrimeCommand<String>{
    public Show(){super("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");}

    @Override
    public void execute(String args, Application application){
        this.setApplication(application);
        for (Product prod:
             application.getProducts().getProducts().values()) {
            System.out.println(prod);
        }
    }
}
