package com.bubla.console.executer;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import lombok.Data;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Scanner;

/** Класс управления командами
 *
 */
@Data
public class CommandManager {
    private Application application;
    private Executer executer;
    private LinkedHashMapOfProducts linkedHashMapOfProducts;
    private Scanner sc;
    private String cmd;
    private StringBuilder arg;
    private boolean isCmd;

    public CommandManager(LinkedHashMap<String, Product> linkedHashMap){
        this.linkedHashMapOfProducts = new LinkedHashMapOfProducts(linkedHashMap);
        this.application = new Application(linkedHashMapOfProducts);
        application.setInputStream(System.in);
        this.executer = new Executer();
    }

    public CommandManager(Application application){
        this.application = application;
        this.executer = new Executer();
    }

    /** Считывание команды из потока-ввода
     *
     * @param inputStream поток-ввода
     */
    public void start(InputStream inputStream){
        sc = new Scanner(inputStream);
        application.setScanner(sc);
        while(this.application.isRunnig()){
            application.setInputStream(inputStream);
            String[] tokens = sc.nextLine().split(" ");
            this.isCmd = true;
            this.cmd = tokens[0];
            this.arg = new StringBuilder();
            for(int i = 1; i < tokens.length; i++){
                if(i != (tokens.length - 1)){
                    arg.append(tokens[i] + " ");
                }
                else{
                    arg.append(tokens[i]);
                }
            }
            try {
                this.executer.accomplish(this.cmd, this.arg.toString(), this.application);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
