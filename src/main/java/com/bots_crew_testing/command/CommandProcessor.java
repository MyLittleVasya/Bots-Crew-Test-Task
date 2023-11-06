package com.bots_crew_testing.command;

/**
 * Class that processes command from command line. Parses command, prompts and call appropriate method.
 */
public interface CommandProcessor {

  /**
   * Process command
   *
   * @param command from console that needs to be proceeded.
   */
  void processCommand(String command);

}

