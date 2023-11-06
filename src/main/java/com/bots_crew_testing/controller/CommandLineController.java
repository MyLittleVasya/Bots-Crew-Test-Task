package com.bots_crew_testing.controller;

import com.bots_crew_testing.command.CommandProcessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Main bean that processes commands from console.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CommandLineController {

  private final CommandProcessor commandProcessor;

  /**
   * Initialize method for reading console until exit is printed.
   *
   * @throws IOException thrown because of console parsing error.
   */
  public void startConsole() throws IOException {
    final var commandReader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final var command = commandReader.readLine();
      final var commandParsed = command.split(" ");
      if (commandParsed[0].equalsIgnoreCase("exit")) {
        break;
      }
      else {
        try {
          commandProcessor.processCommand(command);
        }
        catch (RuntimeException ex) {
          log.error(ex.getMessage());
        }
      }
    }
  }
}
