package com.bots_crew_testing.command;

/**
 * Functional interface that describes method that should handle command with its argument in the end of procession.
 */
@FunctionalInterface
public interface CommandHandler {
  String handle(String argument);

}
