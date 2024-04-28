package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;

public class Exit extends PrimeCommand<String>{
    public Exit(){super("exit : завершить программу");}


    @Override
    public void execute(String args, Application application) {
        application.setRunnig(false);
        this.setApplication(application);
    }
}
