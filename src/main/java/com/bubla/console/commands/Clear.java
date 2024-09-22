package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;


 /** Класс команды clear
 * @author ShablsBubla
 */
public class Clear extends PrimeCommand {
    /** Поле описания комнады*/
    public Clear(){super("clear : очистить коллекцию");}

     /** Метод исполнения команды
      *
      * @param args аргумент команды
      * @param application приложение
      */
     @Override
    public void execute(String args, Application application){
        application.setProducts(new LinkedHashMapOfProducts(application.getProducts().getCreationDate()));
    }
}
