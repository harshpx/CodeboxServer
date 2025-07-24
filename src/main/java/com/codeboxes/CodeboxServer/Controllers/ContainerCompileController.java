package com.codeboxes.CodeboxServer.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeboxes.CodeboxServer.DTOs.CommonResponse;
import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileResponse;
import com.codeboxes.CodeboxServer.Services.ContainerCompileService;

@RestController
@RequestMapping("/api/v2/compile")
@CrossOrigin(origins = "http://localhost:3000")
public class ContainerCompileController {
  @Autowired
  private ContainerCompileService compileService;

  @PostMapping
  public ResponseEntity<CommonResponse<ContainerCodeCompileResponse>> compileCode(
      @RequestBody ContainerCodeCompileRequest request)
      throws IOException, InterruptedException {
    ContainerCodeCompileResponse resultData = compileService.compile(request);
    CommonResponse<ContainerCodeCompileResponse> response = new CommonResponse<>(resultData);
    return ResponseEntity.ok(response);
  }
}
