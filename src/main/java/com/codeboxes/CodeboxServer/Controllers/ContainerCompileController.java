package com.codeboxes.CodeboxServer.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileResponse;

@RestController
@RequestMapping("/api/v2/compile")
public class ContainerCompileController {
  public ResponseEntity<ContainerCodeCompileResponse> compileCode(@RequestBody ContainerCodeCompileRequest request) {
    return null;
  }
}
