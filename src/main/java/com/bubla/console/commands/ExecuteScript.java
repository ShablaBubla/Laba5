package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.exceptions.WrongCommandFormat;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.CommandManager;
import com.bubla.console.executer.Executer;

import java.io.*;
import java.util.Stack;

public class ExecuteScript extends PrimeCommand<String> {
    public ExecuteScript() {
        super("execute_script file_name : считать и исполнить скрипт из указанного файла");
    }


    @Override
    public void execute(String args, Application application) {
        if(application.getCmdStack().contains(args)){
            System.out.println("Рекурсия запрещена!");
        }
        else {
            try{
                application.setInputStream(new FileInputStream(args));
                application.pushCmd(args);
                CommandManager commandManager = new CommandManager(application);
                commandManager.start(application.getInputStream());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                application.popCmd();
            }
        }
    }
}