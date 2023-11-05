package com.bots_crew_testing.config;

import com.bots_crew_testing.command.CommandBuilder;
import com.bots_crew_testing.command.CommandProcessor;
import com.bots_crew_testing.command.CommandProcessorBuilder;
import com.bots_crew_testing.service.DepartmentService;
import com.bots_crew_testing.service.TestServiceMax;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandProcessorConfig {

  @Bean
  public CommandProcessor getPromptProcessor(TestServiceMax testServiceMax, DepartmentService departmentService) {
    return new CommandProcessorBuilder()
        .addCommand(new CommandBuilder("who").prompt("is head of department",
            departmentService::getHeadOfDepartment).createCommand())
        .addCommand(new CommandBuilder("show")
            .prompt("statistics", departmentService::showEmployeeStatistics)
            .prompt("the average salary for the department", departmentService::getAverageSalary)
            .prompt("count of employee for", departmentService::getEmployeeCount)
            .createCommand())
        .addCommand(new CommandBuilder("global")
            .prompt("search by", departmentService::globalSearch)
            .createCommand())
        .build();
  }
}
