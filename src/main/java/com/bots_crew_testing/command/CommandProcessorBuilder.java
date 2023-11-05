package com.bots_crew_testing.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessorBuilder {

  private final Map<String, Command> commands = new HashMap<>();

  public CommandProcessorBuilder addCommand(Command command) {
    commands.put(command.getName(), command);
    return this;
  }

  public CommandProcessor build() {
    return new CommandProcessorImpl(Map.copyOf(commands));
  }
}
