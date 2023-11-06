package com.bots_crew_testing.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder for proper configuration of command processor.
 * <p>We configure pull of supported commands and prompts.</p>
 */
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
