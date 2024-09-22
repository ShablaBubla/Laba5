package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Person;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.HashSet;

/** Класс команды print_unique_owner
 *
 */
public class PrintUniqueOwner extends PrimeCommand {
    /** Поле описания комнады*/
    public PrintUniqueOwner(){super("print_unique_owner : вывести уникальные значения поля owner всех элементов в коллекции");}

    /** Метод исполнения команды
     *
     * @param args аргумент команды
     * @param application приложение
     */
    @Override
    public void execute(String args, Application application) {
        LinkedHashMapOfProducts products = application.getProducts();
        HashSet<Person> owners = new HashSet<>();
        for (Product prod:
                products.getProducts().values()) {
            Person owner = prod.getOwner();
            try {
                if (!owners.contains(owner) & owner != null) {
                    System.out.println(owner);
                }
                owners.add(owner);
            } catch (NullPointerException e){
                System.out.print("");
            }
        }
    }
}
