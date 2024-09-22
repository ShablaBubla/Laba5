package com.bubla.console.commands;

import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.ArrayList;

/** Класс команды print_ascending
 *
 */
public class PrintAscending extends PrimeCommand {
    /** Поле описания комнады*/
    public PrintAscending(){super("print_ascending : вывести элементы коллекции в порядке возрастания");}

    /** Метод исполнения комнады
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        ArrayList<Product> val = application.getProducts().sort();
        for (Product prod:
             val) {
            System.out.println(prod);
        }
    }
}
