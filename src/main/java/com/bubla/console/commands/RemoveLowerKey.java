package com.bubla.console.commands;

import com.bubla.console.executer.Application;

/** Класс команды remove_lower_key
 *
 */
public class RemoveLowerKey extends PrimeCommand {
    /** Поле описания комнады*/
    public RemoveLowerKey(){super("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        for (String key:
             application.getProducts().getProducts().keySet()) {
            if(key.length() < args.length()){
                application.getProducts().remove(key);
            }
        }
    }
}
