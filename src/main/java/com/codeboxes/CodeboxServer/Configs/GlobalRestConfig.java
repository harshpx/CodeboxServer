package com.codeboxes.CodeboxServer.Configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codeboxes.CodeboxServer.DTOs.CommonResponse;

@ControllerAdvice
public class GlobalRestConfig {
  @ExceptionHandler
  public ResponseEntity<CommonResponse<String>> handleAllExceptions(Exception e) {
    CommonResponse<String> response = new CommonResponse<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(400).body(response);
  }
}
