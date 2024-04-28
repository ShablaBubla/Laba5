package com.bubla.console.commands;
import com.bubla.console.executer.Application;

public class Info extends PrimeCommand<String> {
    public Info(){super("info : вывести в стандартный поток вывода информацию о коллекции");}

    @Override
    public void execute(String args, Application application){
        this.setApplication(application);
        System.out.println("Тип коллекции: LinkedHashMap\n" +
                "Дата инициализации: " + this.getApplication().getProducts().getCreationDate() + "\n" +
                "Дата модификации: " + this.getApplication().getProducts().getModDate() + "\n" +
                "Количество элементов:" + this.getApplication().getProducts().getSize() + "\n");
    }
}
