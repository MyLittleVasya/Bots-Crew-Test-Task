package com.bots_crew_testing.controller;

import com.bots_crew_testing.command.CommandProcessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandLineController {

  private final CommandProcessor commandProcessor;

  public void startConsole() throws IOException {
    final var commandReader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final var command = commandReader.readLine();
      final var commandParsed = command.split(" ");
      if (commandParsed[0].equalsIgnoreCase("exit")) {
        break;
      }
      else {
        commandProcessor.processCommand(command);
      }
    }
  }
}
