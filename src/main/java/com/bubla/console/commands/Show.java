package com.bubla.console.commands;


import com.bubla.console.executer.Application;

/** Класс команды show
 *
 */
public class Show extends PrimeCommand {
    /** Поле описания комнады*/
    public Show(){super("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application){
        for (String key:
             application.getProducts().getProducts().keySet()) {
            System.out.println(key + " " + application.getProducts().getProducts().get(key));
        }
    }
}
