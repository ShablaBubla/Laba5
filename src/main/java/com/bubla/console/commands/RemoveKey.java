package com.bubla.console.commands;

import com.bubla.console.executer.Application;

/** Класс команды remove_key
 *
 */
public class RemoveKey extends PrimeCommand {
    /** Поле описания комнады*/
    public RemoveKey(){super("remove_key null : удалить элемент из коллекции по его ключу");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application){
        application.getProducts().remove(args);
    }
}
