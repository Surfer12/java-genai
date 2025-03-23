package com.google.genai.examples;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import java.io.IOException;
import org.apache.http.HttpException;

public class GenAiService {

  private final Client client;

  public GenAiService() throws IOException {
    this.client = new Client();
  }

  public GenerateContentResponse generateContent(String model, String prompt, Object context)
      throws IOException, HttpException {
    return client.models.generateContent(model, prompt, context);
  }
}