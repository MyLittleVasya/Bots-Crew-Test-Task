package com.bots_crew_testing;

import com.bots_crew_testing.controller.CommandLineController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BotsCrewTestingApplication {

  public static void main(String[] args) {
    log.info("Application starting");
    SpringApplication.run(BotsCrewTestingApplication.class, args);
    log.info("Application working");
  }

  @Bean
  public CommandLineRunner run(CommandLineController commandLineController) {
    log.info("Command line application starting");
    return args -> commandLineController.startConsole();
  }
}
