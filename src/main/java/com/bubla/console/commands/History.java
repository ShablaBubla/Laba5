package com.bubla.console.commands;

import com.bubla.console.executer.Application;

public class History extends PrimeCommand<String>{

    public History(){super("history : вывести последние 5 команд");}

    @Override
    public void execute(String args, Application application) {
        String[] history = application.getHistory();
        int count = application.getCounter();
        for(int i = 0; i < 5; i++){
            System.out.println(history[count]);
            count = (count - 1) % 5;
        }
        this.setApplication(application);
    }
}
