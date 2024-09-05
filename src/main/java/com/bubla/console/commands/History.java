package com.bubla.console.commands;

import com.bubla.console.executer.Application;

public class History extends PrimeCommand<String>{

    public History(){super("history : вывести последние 5 команд");}

    @Override
    public void execute(String args, Application application) {
        String[] history = application.getHistory();
        int counter = application.getCounter();
        int count = ((counter - 1) % 6 + 6) % 6;
        for(int i = 1; i < 6; i++){
            if(history[count] == null){
                continue;
            }
            System.out.println(history[count]);
            count = ((count - 1) + 6) % 6;
        }
    }
}
