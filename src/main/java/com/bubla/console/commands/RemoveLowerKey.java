package com.bubla.console.commands;

import com.bubla.console.executer.Application;

import java.util.Comparator;

public class RemoveLowerKey extends PrimeCommand<String>{
    public RemoveLowerKey(){super("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");}


    @Override
    public void execute(String args, Application application) {
        for (String key:
             application.getProducts().getProducts().keySet()) {
            if(key.compareTo(args)<0){
                application.getProducts().remove(key);
            }
        }
    }
}
