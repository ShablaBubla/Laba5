package com.bubla.console.commands;

import com.bubla.console.executer.Application;

/** Класс команды history*/
public class History extends PrimeCommand {
    /** Поле описания комнады*/
    public History(){super("history : вывести последние 5 команд");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        String[] history = application.getHistory();
        int counter = application.getCounter();
        int count = ((counter - 1) % 6 + 6) % 6;
        for(int i = 1; i < 6; i++){
            if(history[count] == null){
                continue;
            }
            System.out.println(i + ". "+ history[count]);
            count = ((count - 1) + 6) % 6;
        }
    }
}
