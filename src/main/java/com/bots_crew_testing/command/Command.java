package com.bots_crew_testing.command;

import java.util.HashMap;
import java.util.Map;

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
