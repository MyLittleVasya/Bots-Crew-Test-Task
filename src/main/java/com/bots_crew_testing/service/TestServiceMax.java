package com.bots_crew_testing.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceMax {

  public String proceed(String argument) {
    System.out.println("ALL IS GOOD" + argument);
    return argument;
  }

}
