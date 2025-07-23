package com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContainerCodeCompileRequest {
  @NotNull
  private String code;
  @NotNull
  private String language;
  @NotNull
  private String input;

  public ContainerCodeCompileRequest() {
  }

  public ContainerCodeCompileRequest(String code, String language, String input) {
    this.code = code;
    this.language = language;
    this.input = input;
  }
}
