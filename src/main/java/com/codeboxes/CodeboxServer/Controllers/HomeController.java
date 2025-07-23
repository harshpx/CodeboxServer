package com.codeboxes.CodeboxServer.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeboxes.CodeboxServer.DTOs.CommonResponse;

@RestController
public class HomeController {
  @GetMapping
  public ResponseEntity<CommonResponse<String>> home() {
    CommonResponse<String> response = new CommonResponse<>("Spring API is running!");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
