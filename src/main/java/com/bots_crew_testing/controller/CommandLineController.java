package com.bots_crew_testing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;

@Component
public class CommandLineController {

  public void startConsole() throws IOException {
    final var commandReader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final var command = commandReader.readLine();
      final var commandParsed = command.split(" ");
      if (commandParsed[0].equalsIgnoreCase("exit")) {
        break;
      }
    }
  }
}
