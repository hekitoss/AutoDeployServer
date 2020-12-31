package Commands;

import Commands.Impl.CreateUser;
import Commands.Impl.DeleteUser;
import Commands.Impl.Error;
import Commands.Impl.GoToMain;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandsName, Command> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(CommandsName.CREATE, new CreateUser());
        commandMap.put(CommandsName.DELETE, new DeleteUser());
        commandMap.put(CommandsName.ERROR, new Error());
        commandMap.put(CommandsName.GO_TO_MAIN, new GoToMain());
    }

public Command getCommand(String name){
    CommandsName commandName;
    Command command;
    try {
        commandName = CommandsName.valueOf(name.toUpperCase());
        command = commandMap.get(commandName);
    } catch (IllegalArgumentException | NullPointerException e) {
        command = commandMap.get(CommandsName.ERROR);
    }
    return command;
}
}
