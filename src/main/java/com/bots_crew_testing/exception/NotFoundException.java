package com.bots_crew_testing.exception;

import java.io.Serial;

public class NotFoundException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = 883544908691383465L;

  public NotFoundException(String message) {
    super(message);
  }
}
