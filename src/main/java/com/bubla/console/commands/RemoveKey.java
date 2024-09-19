package com.bubla.console.commands;

import com.bubla.console.executer.Application;

public class RemoveKey extends PrimeCommand<String> {
    public RemoveKey(){super("remove_key null : удалить элемент из коллекции по его ключу");}

    @Override
    public void execute(String args, Application application){
        application.getProducts().remove(args);
    }
}
