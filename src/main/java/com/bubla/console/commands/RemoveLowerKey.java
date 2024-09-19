package com.bubla.console.commands;

import com.bubla.console.executer.Application;


public class RemoveLowerKey extends PrimeCommand<String>{
    public RemoveLowerKey(){super("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");}


    @Override
    public void execute(String args, Application application) {
        for (String key:
             application.getProducts().getProducts().keySet()) {
            if(key.length() < args.length()){
                application.getProducts().remove(key);
            }
        }
    }
}
