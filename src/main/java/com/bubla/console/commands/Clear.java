package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;

public class Clear extends PrimeCommand<String>{
    public Clear(){super("clear : очистить коллекцию");}

    public void execute(String args, Application application){
        application.setProducts(new LinkedHashMapOfProducts());
    }
}
