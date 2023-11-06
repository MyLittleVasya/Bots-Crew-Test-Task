package com.bots_crew_testing.exception;

import java.io.Serial;
import java.io.Serializable;

public class ParsingException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = -156212154679598234L;

  public ParsingException(String message) {
    super(message);
  }
}
