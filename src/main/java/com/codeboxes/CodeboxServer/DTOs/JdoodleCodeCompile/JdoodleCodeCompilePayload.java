package com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JdoodleCodeCompilePayload {
  private String clientId;
  private String clientSecret;
  private String script;
  private String stdin;
  private String language;
  private String versionIndex;
  private boolean compileOnly;

  // constructors
  public JdoodleCodeCompilePayload() {
  }

  public JdoodleCodeCompilePayload(String code, String language, String input) {
    this.script = code;
    this.stdin = input;
    this.language = language;
    this.versionIndex = "0";
    this.compileOnly = false;
  }

  public JdoodleCodeCompilePayload(JdoodleCodeCompileRequest request) {
    this.script = request.getCode();
    this.stdin = request.getInput();
    this.language = request.getLanguage();
    this.versionIndex = "0";
    this.compileOnly = false;
  }

  public String toString() {
    return "CodeCompilePayload{" +
        "clientId='" + clientId + '\'' +
        ", clientSecret='" + clientSecret + '\'' +
        ", script='" + script + '\'' +
        ", stdin='" + stdin + '\'' +
        ", language='" + language + '\'' +
        ", versionIndex='" + versionIndex + '\'' +
        ", compileOnly=" + compileOnly +
        '}';
  }
}
