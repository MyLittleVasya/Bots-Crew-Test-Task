package com.bots_crew_testing.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains core structure of supported command.
 * <p>Example: show "name_of_department" statistics</p>
 * <p>Usually it consists of 3 parts:</p>
 * <p>1 part - "show". Its like category of command, because there can be several "show" commands</p>
 * <p>
 *   2 part - "statistics". It can be both before and after argument.
 *   Also it can consist of several words with spaces.
 *   Its part thad describes what we really should do. Its called prompt.
 * </p>
 * <p>3 argument is "name_of_department". Its argument that will be passed into function.</p>
 */
public final class Command {
  private final String name;
  private final Map<String, CommandHandler> prompts;

  public Command(String name) {
    this.name = name;
    this.prompts = new HashMap<>();
  }

  public Command(String name, Map<String, CommandHandler> commands) {
    this.name = name;
    this.prompts = Map.copyOf(commands);
  }

  public String getName() {
    return name;
  }

  public Map<String, CommandHandler> getPrompts() {
    return Map.copyOf(prompts);
  }
}
