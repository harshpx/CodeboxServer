package com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContainerCodeCompileResponse {
  private String output;
  private String error;

  public ContainerCodeCompileResponse() {
  }

  public ContainerCodeCompileResponse(String output) {
    this.output = output;
    this.error = null;
  }

  public ContainerCodeCompileResponse(String output, String error) {
    this.output = output;
    this.error = error;
  }
}
