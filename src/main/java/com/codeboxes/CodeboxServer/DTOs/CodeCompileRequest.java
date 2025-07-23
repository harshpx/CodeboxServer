package com.codeboxes.CodeboxServer.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeCompileRequest {
  @NotNull
  private String code;
  @NotNull
  private String language;
  @NotNull
  private String input;

  public CodeCompileRequest() {
  }

  public CodeCompileRequest(String code, String language, String input) {
    this.code = code;
    this.language = language;
    this.input = input;
  }

  public String toString() {
    return "CodeCompileRequest{" +
        "code='" + code + '\'' +
        ", language='" + language + '\'' +
        ", input='" + input + '\'' +
        '}';
  }
}
