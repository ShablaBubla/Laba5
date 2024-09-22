package com.bubla.console.commands;

import com.bubla.console.executer.Application;
import com.bubla.console.file_managment.Write;

/** Класс команды save
 *
 */
public class Save extends PrimeCommand {
    /** Поле описания комнады*/
    public Save(){super("save : сохранить коллекцию в файл");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application){
            Write write = new Write(application.getProducts().getProducts(), System.getenv("FILE_PATH"));
            write.record();
    }
}
