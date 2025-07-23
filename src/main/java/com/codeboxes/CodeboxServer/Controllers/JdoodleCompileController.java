package com.codeboxes.CodeboxServer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeboxes.CodeboxServer.DTOs.CommonResponse;
import com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile.JdoodleCodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile.JdoodleCodeCompileResponse;
import com.codeboxes.CodeboxServer.Services.JdoodleCompileService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/compile")
@CrossOrigin(origins = "http://localhost:3000")
public class JdoodleCompileController {
  @Autowired
  private JdoodleCompileService compileService;

  @PostMapping
  public Mono<ResponseEntity<CommonResponse<JdoodleCodeCompileResponse>>> compileCode(
      @RequestBody JdoodleCodeCompileRequest request) {
    Mono<JdoodleCodeCompileResponse> rawResponse = compileService.compileCode(request);
    return rawResponse.map(monoResponse -> {
      CommonResponse<JdoodleCodeCompileResponse> response = new CommonResponse<>(monoResponse);
      return ResponseEntity.ok(response);
    });
  }
}
