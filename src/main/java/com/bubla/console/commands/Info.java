package com.bubla.console.commands;
import com.bubla.console.executer.Application;

/** Класс команды info*/
public class Info extends PrimeCommand {
    /** Поле описания комнады*/
    public Info(){super("info : вывести в стандартный поток вывода информацию о коллекции");}

    /** Метод исполения команды
     *
     * @param args аргумент команды
     * @param application прилодение
     */
    @Override
    public void execute(String args, Application application){
        System.out.println("Тип коллекции: LinkedHashMap\n" +
                "Дата инициализации: " + application.getProducts().getCreationDate() + "\n" +
                "Дата модификации: " + application.getProducts().getModDate() + "\n" +
                "Количество элементов:" + application.getProducts().getSize());
    }
}
