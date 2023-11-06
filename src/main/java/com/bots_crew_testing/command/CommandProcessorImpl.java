package com.bots_crew_testing.command;

import com.bots_crew_testing.exception.ParsingException;
import java.util.Map;

public class CommandProcessorImpl implements CommandProcessor {

  private final Map<String, Command> commands;

  protected CommandProcessorImpl(Map<String, Command> commands) {
    this.commands = commands;
  }

  @Override
  public void processCommand(String commandString) {
    for (final var commandKey:commands.keySet()) {
      final var commandSplitted = commandString.split(commandKey);
      if (validateSplittedCommand(commandSplitted, commandString)) {
        commandString = commandSplitted[1];

        for (final var promptKey:commands.get(commandKey).getPrompts().keySet()) {
          final var promptSplitted = commandString.split(promptKey);
          if (validateSplittedCommand(promptSplitted, commandString)) {
            if (promptSplitted.length == 1) {
              System.out.println(commands.get(commandKey).getPrompts().get(promptKey).handle(promptSplitted[0].strip()));
            }
            else {
              System.out.println(commands.get(commandKey).getPrompts().get(promptKey).handle(promptSplitted[1].strip()));
            }
          }
        }
      }
    }
    throw new ParsingException("Unknown command, list of available commands + \n" + commands.keySet());
  }

  private boolean validateSplittedCommand(String[] command, String originalCommand) {
    if (command.length == 1 && !command[0].equals(originalCommand)) {
      return true;
    }
    else if (command.length == 2 && !command[1].equals(originalCommand)) {
      return true;
    }
    throw new ParsingException("Unknown command, list of available commands + \n" + commands.keySet());
  }
}
