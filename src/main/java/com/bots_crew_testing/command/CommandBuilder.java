package com.bots_crew_testing.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder for creation of {@link Command}.
 */
public class CommandBuilder {

  private final String command;

  /**
   * String is prompt, CommandHandler is lambda method reference {@link CommandHandler} that will handle appropriate command.
   */
  private Map<String, CommandHandler> prompts;

  public CommandBuilder(String command) {
    this.command = command;
    this.prompts = new HashMap<>();
  }

  public CommandBuilder prompt(String prompt, CommandHandler handler) {
    this.getPrompts().put(prompt, handler);
    return this;
  }

  public Command createCommand() {
    return new Command(command, prompts);
  }

  public String getCommand() {
    return command;
  }

  public Map<String, CommandHandler> getPrompts() {
    return prompts;
  }
}
