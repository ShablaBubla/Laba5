package com.bubla.console.commands;

import com.bubla.classes.*;
import com.bubla.console.executer.Application;

public class Show extends PrimeCommand<String>{
    public Show(){super("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");}

    @Override
    public void execute(String args, Application application){
        for (String key:
             application.getProducts().getProducts().keySet()) {
            System.out.println(key + " " + application.getProducts().getProducts().get(key));
        }
    }
}
