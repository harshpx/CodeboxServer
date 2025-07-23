package com.codeboxes.CodeboxServer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeboxes.CodeboxServer.DTOs.CodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.CodeCompileResponse;
import com.codeboxes.CodeboxServer.DTOs.CommonResponse;
import com.codeboxes.CodeboxServer.Services.CompileService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/compile")
@CrossOrigin(origins = "http://localhost:3000")
public class CompileController {
  @Autowired
  private CompileService compileService;

  @PostMapping
  public Mono<ResponseEntity<CommonResponse<CodeCompileResponse>>> compileCode(
      @RequestBody CodeCompileRequest request) {
    Mono<CodeCompileResponse> rawResponse = compileService.compileCode(request);
    return rawResponse.map(monoResponse -> {
      CommonResponse<CodeCompileResponse> response = new CommonResponse<>(monoResponse);
      return ResponseEntity.ok(response);
    });
  }
}
