package com.bubla.console.commands;


import com.bubla.console.executer.Application;

/** Класс команды exit */
public class Exit extends PrimeCommand {
    /** Поле описания комнады*/
    public Exit(){super("exit : завершить программу");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        application.setRunnig(false);
    }
}
