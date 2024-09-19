package com.bubla.console.executer;

import com.bubla.classes.LinkedHashMapOfProducts;
import lombok.Data;

import java.util.Stack;

@Data

public class Application {
    private LinkedHashMapOfProducts products = new LinkedHashMapOfProducts();
    private String[] history = new String[6];
    private int counter = 0;
    private boolean isRunnig = true;
    private Stack<String> cmdStack = new Stack<>();

    public Application(LinkedHashMapOfProducts products){
        this.products = products;
    }

    public void updateHistory(String cmd){
        this.counter = (this.counter + 1) % 6;
        this.history[counter] = cmd;
    }

    public void pushCmd(String cmd){
        cmdStack.push(cmd);
    }

    public String popCmd(){
        return cmdStack.pop();
    }
}
