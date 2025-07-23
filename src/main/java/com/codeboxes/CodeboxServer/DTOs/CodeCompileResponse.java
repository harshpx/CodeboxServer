package com.codeboxes.CodeboxServer.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeCompileResponse {
  private String output;
  private String error;
  private int statusCode;
  private String memory;
  private String cpuTime;
  private Integer compilationStatus;
  private String projectKey;
  private boolean isExecutionSuccess;
  private boolean isCompiled;

  public CodeCompileResponse() {
  }

  public CodeCompileResponse(String output, String error, int statusCode, String memory, String cpuTime,
      Integer compilationStatus, String projectKey, boolean isExecutionSuccess, boolean isCompiled) {
    this.output = output;
    this.error = error;
    this.statusCode = statusCode;
    this.memory = memory;
    this.cpuTime = cpuTime;
    this.compilationStatus = compilationStatus;
    this.projectKey = projectKey;
    this.isExecutionSuccess = isExecutionSuccess;
    this.isCompiled = isCompiled;
  }
}