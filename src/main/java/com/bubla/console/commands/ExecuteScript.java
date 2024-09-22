package com.bubla.console.commands;

import com.bubla.console.executer.Application;
import com.bubla.console.executer.CommandManager;

import java.io.*;

/** Класс команды execute_script
 * @author ShablsBubla
 */
public class ExecuteScript extends PrimeCommand {
    /** Поле описания комнады*/
    public ExecuteScript() {
        super("execute_script file_name : считать и исполнить скрипт из указанного файла");
    }

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        if(application.getCmdStack().contains(args)){
            System.out.println("Рекурсия запрещена!");
        }
        else {
            try{
                application.pushCmd(args);
                application.setInputStream(new FileInputStream(args));
                CommandManager commandManager = new CommandManager(application);
                commandManager.start(application.getInputStream());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                application.popCmd();
            }
        }
    }
}