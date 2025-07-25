package com.codeboxes.CodeboxServer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile.JdoodleCodeCompilePayload;
import com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile.JdoodleCodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.JdoodleCodeCompile.JdoodleCodeCompileResponse;

import reactor.core.publisher.Mono;

@Service
public class JdoodleCompileService {
  @Autowired
  private WebClient webClient;

  @Value("${jdoodle.client.id}")
  private String clientId;
  @Value("${jdoodle.client.secret}")
  private String clientSecret;

  private final String uri = "https://api.jdoodle.com/v1/execute";

  public Mono<JdoodleCodeCompileResponse> compileCode(JdoodleCodeCompileRequest request) {

    JdoodleCodeCompilePayload payload = new JdoodleCodeCompilePayload(request);
    payload.setClientId(clientId);
    payload.setClientSecret(clientSecret);

    return webClient.post()
        .uri(uri)
        .header("Content-Type", "application/json")
        .body(Mono.just(payload), JdoodleCodeCompilePayload.class)
        .retrieve()
        .bodyToMono(JdoodleCodeCompileResponse.class);
  }
}
