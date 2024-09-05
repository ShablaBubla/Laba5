package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;
import com.bubla.console.exceptions.WrongCommandFormat;

public class Help extends PrimeCommand<String>{
    public Help(){super("help : вывести справку по доступным командам");}

    @Override
    public void execute(String args, Application application){
        Executer ex = new Executer();
        for (PrimeCommand<String> cmd:
             ex.getCommandsList().values()) {
            System.out.println(cmd.getDescription());
        }
    }
}
