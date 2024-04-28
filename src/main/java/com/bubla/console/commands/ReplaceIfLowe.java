package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;

public class ReplaceIfLowe extends PrimeCommand<String> {
    public ReplaceIfLowe(){super("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");}

    @Override
    public void execute(String args, Application application) {

    }
}
