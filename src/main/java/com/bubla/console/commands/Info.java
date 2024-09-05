package com.bubla.console.commands;
import com.bubla.console.executer.Application;

public class Info extends PrimeCommand<String> {
    public Info(){super("info : вывести в стандартный поток вывода информацию о коллекции");}

    @Override
    public void execute(String args, Application application){
        System.out.println("Тип коллекции: LinkedHashMap\n" +
                "Дата инициализации: " + application.getProducts().getCreationDate() + "\n" +
                "Дата модификации: " + application.getProducts().getModDate() + "\n" +
                "Количество элементов:" + application.getProducts().getSize());
    }
}
