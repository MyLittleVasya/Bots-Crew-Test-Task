package com.bots_crew_testing;

import com.bots_crew_testing.controller.CommandLineController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Starting point of application
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
@RequiredArgsConstructor
public class BotsCrewTestingApplication {

  public static void main(String[] args) {
    log.info("Application starting");
    SpringApplication.run(BotsCrewTestingApplication.class, args);
  }

  /**
   * Bean of CommandLineRunner to start our app as console app.
   *
   * @param commandLineController injectable bean for parsing commands.
   * @return CommandLineRunner instance.
   */
  @Bean
  public CommandLineRunner run(CommandLineController commandLineController) {
    log.info("Command line application starting");
    return args -> commandLineController.startConsole();
  }
}
