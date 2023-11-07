package com.bots_crew_testing.command;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info(String.format("Processing command type of \"%s\"", commandKey));
        commandString = commandSplitted[1];
        for (final var promptKey:commands.get(commandKey).getPrompts().keySet()) {
          final var promptSplitted = commandString.split(promptKey);
          if (validateSplittedCommand(promptSplitted, commandString)) {
            if (promptSplitted.length == 1) {
              log.info(String.format("Processing command type of \"%s\" with prompt \"%s\"", commandKey, promptKey));
              System.out.println(commands.get(commandKey).getPrompts().get(promptKey).handle(promptSplitted[0].strip()));
            }
            else {
              log.info(String.format("Processing command type of \"%s\" with prompt \"%s\"", commandKey, promptKey));
              System.out.println(commands.get(commandKey).getPrompts().get(promptKey).handle(promptSplitted[1].strip()));
            }
          }
        }
      }
    }
  }

  private boolean validateSplittedCommand(String[] command, String originalCommand) {
    if (command.length == 1 && !command[0].equals(originalCommand)) {
      return true;
    }
    else if (command.length == 2 && !command[1].equals(originalCommand)) {
      return true;
    }
    return false;
  }
}
