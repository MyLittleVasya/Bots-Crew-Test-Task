package com.bots_crew_testing.command;

@FunctionalInterface
public interface CommandHandler {
  String handle(String argument);

}
