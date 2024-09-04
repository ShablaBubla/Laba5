package com.bubla.console.executer;

import com.bubla.console.commands.*;
import com.bubla.console.exceptions.NoSuchCommandException;
import lombok.Data;
import java.util.HashMap;

@Data
public class Executer {
    private HashMap<String, PrimeCommand<String>> commandsList;
    private Application application;
    public Executer(Application application){
        this.commandsList = new HashMap<String, PrimeCommand<String>>();
        commandsList.put("help", new Help());
        commandsList.put("info", new Info());
        commandsList.put("show", new Show());
        commandsList.put("insert", new Insert());
        commandsList.put("update", new Update());
        commandsList.put("remove_key", new RemoveKey());
        commandsList.put("clear", new Clear());
        commandsList.put("save", new Save());
        commandsList.put("execute_script", new ExecuteScript());
        commandsList.put("exit", new Exit());
        commandsList.put("replace_if_lowe", new ReplaceIfLowe());
        commandsList.put("remove_lower_key", new RemoveLowerKey());
        commandsList.put("print_ascending", new PrintAscending());
        commandsList.put("print_unique_owner", new PrintUniqueOwner());
        commandsList.put("print_field_descending_unit_of_measure", new PrintFieldDescendingUnitOfMeasure());
        commandsList.put("history", new History());
        this.application = application;
    }
    public void accomplish(String cmd, String args) throws NoSuchCommandException {
        PrimeCommand<String> command = this.commandsList.get(cmd);
        String[] history = application.getHistory();
        try {
            application.updateHistory(cmd);
            command.execute(args, application);
            application = command.getApplication();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new NoSuchCommandException(cmd);
        }
    }
}
