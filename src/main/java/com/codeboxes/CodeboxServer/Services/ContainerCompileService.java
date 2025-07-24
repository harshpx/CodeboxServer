package com.codeboxes.CodeboxServer.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileRequest;
import com.codeboxes.CodeboxServer.DTOs.ContainerCodeCompile.ContainerCodeCompileResponse;

@Service
public class ContainerCompileService {
  public ContainerCodeCompileResponse compile(ContainerCodeCompileRequest request)
      throws IOException, InterruptedException {
    // Validate request
    if (request == null || request.getCode() == null) {
      throw new RuntimeException("Invalid request, please check your payload");
    }

    // Encode code and input to Base64
    String encodedCode = Base64.getEncoder().encodeToString(request.getCode().getBytes());
    String encodedInput = Base64.getEncoder()
        .encodeToString(request.getInput() != null ? request.getInput().getBytes() : new byte[0]);

    // // Run docker container with CODE and INPUT as env variables
    ProcessBuilder processBuilder = new ProcessBuilder(
        "docker", "run", "--rm",
        "-e", "LANGUAGE=" + request.getLanguage(),
        "-e", "CODE_B64=" + encodedCode,
        "-e", "INPUT_B64=" + encodedInput,
        "code-runner");

    // start the process
    Process process = processBuilder.start();
    // capture output (stdout)
    BufferedReader outReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    StringBuilder output = new StringBuilder();
    String line;
    while ((line = outReader.readLine()) != null) {
      output.append(line).append("\n");
    }
    // capture error (stderr)
    BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    StringBuilder error = new StringBuilder();
    while ((line = errReader.readLine()) != null) {
      error.append(line).append("\n");
    }
    // exit process
    process.waitFor();

    // set output & error in response object
    ContainerCodeCompileResponse response = new ContainerCodeCompileResponse();
    response.setOutput(output.toString());
    response.setError(error.toString());

    return response;
  }
}
