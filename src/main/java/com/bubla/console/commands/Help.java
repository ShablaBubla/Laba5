package com.bubla.console.commands;

import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;

/** Класс команды help*/
public class Help extends PrimeCommand {
    /** Поле описания комнады*/
    public Help(){super("help : вывести справку по доступным командам");}

    /** Метод выполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application){
        Executer ex = new Executer();
        for (PrimeCommand cmd:
             ex.getCommandsList().values()) {
            System.out.println(cmd.getDescription());
        }
    }
}
