# Google Gen AI Java SDK

Java idiomatic SDK for the
[Gemini Developer APIs][gemini-api-doc] and [Vertex AI][vertex-api-doc] APIs.

[![Maven][maven-version-image]][maven-version-link]

This is an early release. API is subject to change. Please do not use this SDK
in production environments at this stage.

## Add dependency

If you're using Maven, add the following to your dependencies:

<!-- {x-version-update-start:google-genai:released} -->

```xml
<dependencies>
  <dependency>
    <groupId>com.google.genai</groupId>
    <artifactId>google-genai</artifactId>
    <version>0.2.0</version> <!-- {x-version-update:google-genai:released} -->
  </dependency>
</dependencies>
```

<!-- {x-version-update-end} -->

## Getting Started

Follow the instructions in this section to get started using the Google Gen AI
SDK for Java.

You can either set the following environment variables or pass them to the
client builder explicitly:

```bash
GOOGLE_API_KEY=${GEMINI_API_KEY}      # Required to call Gemini APIs
GOOGLE_CLOUD_PROJECT=${PROJECT_NAME}  # Required to call Vertex AI APIs
GOOGLE_CLOUD_LOCATION=${LOCATION}     # Required to call Vertex AI APIs
```

### Create a client
The Google Gen AI Java SDK provides a Client class, simplifying interaction
with both the Gemini API and Vertex AI API. With minimal configuration,
you can seamlessly switch between the 2 backends without rewriting
your code.

#### Instantiate a client that uses Gemini API
```java
import com.google.genai.Client;

// The simplest way for instantiation. The client gets the API key from the
// environment variable `GOOGLE_API_KEY` and use Gemini API when the environment
// variable `GOOGLE_GENAI_USE_VERTEXAI` is not set or set to `false`.
Client client = new Client();

// Use Builder class for instantiation. Explicitly set the API key to use Gemini
// Developer backend.
Client client = Client.builder().apiKey("your-api-key").build();
```

#### Instantiate a client that uses Vertex AI API
```java
import com.google.genai.Client;

// The client gets the project and location from the environment variable
// `GOOGLE_CLOUD_PROJECT` and `GOOGLE_CLOUD_LOCATION`. It uses Vertex AI APIs
// when the environment variable `GOOGLE_GENAI_USE_VERTEXAI` is set to `true`.
Client client = new Client();

// Use Builder class for instantiation. Explicitly set the project and location,
// and set `vertexAI(true)` to use Vertex AI backend.
Client client = Client.builder()
  .project("your-project")
  .location("your-location")
  .vertexAI(true)
  .build();
```

### Interact with models
The Gen AI Java SDK allows you to access the service programmatically.
The following code snippets are some basic usages of model inferencing.

#### Generate Content
Use `generateContent` method for the most basic text generation.

##### with text input

```java
package <your package name>;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import java.io.IOException;
import org.apache.http.HttpException;

public class GenerateContentWithTextInput {
  public static void main(String[] args) throws IOException, HttpException {
    // Instantiate the client. The client by default uses the Gemini API. It gets
    // the API key from the environment variable `GOOGLE_API_KEY`.
    Client client = new Client();

    GenerateContentResponse response =
        client.models.generateContent("gemini-2.0-flash-001", "What is your name?", null);

    // Gets the text string from the response by the quick accessor method `text()`.
    System.out.println("Unary response: " + response.text());
  }
}
```

##### with text and image input

```java
package <your package name>;

import com.google.common.collect.ImmutableList;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;
import java.io.IOException;
import org.apache.http.HttpException;

public class GenerateContentWithImageInput {
  public static void main(String[] args) throws IOException, HttpException {
    // Instantiate the client using Vertex API. The client gets the project and location from the
    // environment variables `GOOGLE_CLOUD_PROJECT` and `GOOGLE_CLOUD_LOCATION`.
    Client client = Client.builder().vertexAI(true).build();

    // Create parts from builder or `fromJson` method.
    Part textPart = Part.builder().text("describe the image").build();
    Part imagePart =
        Part.fromJson(
            "{\"fileData\":{\"mimeType\":\"image/jpeg\",\"fileUri\":\"gs://path/to/image.jpg\"}}");

    Content content =
        Content.builder().role("user").parts(ImmutableList.of(textPart, imagePart)).build();

    GenerateContentResponse response =
        client.models.generateContent("gemini-2.0-flash-001", content, null);

    System.out.println("Response: " + response.text());
  }
}
```

#### Stream Generated Content
To get a streamed response, you can use the `generateContentStream` method:

```java
package <your package name>;

import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.GenerateContentResponse;
import java.io.IOException;
import org.apache.http.HttpException;

public class StreamGeneration {
  public static void main(String[] args) throws IOException, HttpException {
    // Instantiate the client using Vertex API. The client gets the project and location from the
    // environment variables `GOOGLE_CLOUD_PROJECT` and `GOOGLE_CLOUD_LOCATION`.
    Client client = Client.builder().vertexAI(true).build();

    ResponseStream<GenerateContentResponse> responseStream =
        client.models.generateContentStream(
            "gemini-2.0-flash-001", "Tell me a story in 300 words.", null);

    System.out.println("Streaming response: ");
    for (GenerateContentResponse res : responseStream) {
      System.out.print(res.text());
    }

    // To save resources and avoid connection leaks, it is recommended to close the response
    // stream after consumption (or using try block to get the response stream).
    responseStream.close();
  }
}
```

#### Async Generate Content
To get a response asynchronously, you can use the `generateContent` method from
the `client.async.models` namespace.

```java
package <your package name>;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.apache.http.HttpException;

public class GenerateContentAsync {
  public static void main(String[] args) throws IOException, HttpException {
    // Instantiates the client using Gemini API, and sets the API key in the builder.
    Client client = Client.builder().apiKey("your-api-key").build();

    CompletableFuture<GenerateContentResponse> responseFuture =
        client.async.models.generateContent(
            "gemini-2.0-flash-001", "Introduce Google AI Studio.", null);

    responseFuture
        .thenAccept(
            response -> {
              System.out.println("Async response: " + response.text());
            })
        .join();
  }
}
```

#### Generate Content with extra configs
To set configurations like System Instructions and Safety Settings, you can pass
a `GenerateContentConfig` to the `GenerateContent` method.

```java
package <your package name>;

import com.google.common.collect.ImmutableList;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.GoogleSearch;
import com.google.genai.types.Part;
import com.google.genai.types.SafetySetting;
import com.google.genai.types.Tool;
import java.io.IOException;
import org.apache.http.HttpException;

public class GenerateContentWithConfigs {
  public static void main(String[] args) throws IOException, HttpException {
    Client client = new Client();

    // Sets the safety settings in the config.
    ImmutableList<SafetySetting> safetySettings =
        ImmutableList.of(
            SafetySetting.builder()
                .category("HARM_CATEGORY_HATE_SPEECH")
                .threshold("BLOCK_ONLY_HIGH")
                .build(),
            SafetySetting.builder()
                .category("HARM_CATEGORY_DANGEROUS_CONTENT")
                .threshold("BLOCK_LOW_AND_ABOVE")
                .build());

    // Sets the system instruction in the config.
    Content systemInstruction =
        Content.builder()
            .parts(ImmutableList.of(Part.builder().text("Answer as concisely as possible").build()))
            .build();

    // Sets the Google Search tool in the config.
    Tool googleSearchTool = Tool.builder().googleSearch(GoogleSearch.builder().build()).build();

    GenerateContentConfig config =
        GenerateContentConfig.builder()
            .candidateCount(1)
            .maxOutputTokens(1024)
            .safetySettings(safetySettings)
            .systemInstruction(systemInstruction)
            .tools(ImmutableList.of(googleSearchTool))
            .build();

    GenerateContentResponse response =
        client.models.generateContent("gemini-2.0-flash-001", "Tell me the history of LLM", config);

    System.out.println("Response: " + response.text());
  }
}
```

#### Generate Content with JSON response schema
To get a response in JSON by passing in a response schema to the
`GenerateContent` API.

```java
package <your package name>;

import com.google.common.collect.ImmutableMap;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Schema;
import java.io.IOException;
import org.apache.http.HttpException;

public class GenerateContentWithSchema {
  public static void main(String[] args) throws IOException, HttpException {
    Client client = new Client();

    Schema schema =
        Schema.builder()
            .type("object")
            .properties(
                ImmutableMap.of(
                    "name", Schema.builder().type("string").description("Your Name").build()))
            .build();
    GenerateContentConfig config =
        GenerateContentConfig.builder()
            .responseMimeType("application/json")
            .candidateCount(1)
            .responseSchema(schema)
            .build();

    GenerateContentResponse response =
        client.models.generateContent("gemini-2.0-flash-001", "Tell me your name", config);

    System.out.println("Response: " + response.text());
  }
}
```

## API Key Setup

### Securing Your API Key

1. Obtain an API key from [Google AI Studio](https://aistudio.google.com/app/apikey)
2. Set the API key as an environment variable:

   ```bash
   # For macOS/Linux
   export GOOGLE_API_KEY=your_actual_api_key
   
   # For Windows (PowerShell)
   $env:GOOGLE_API_KEY="your_actual_api_key"
   
   # For Windows (Command Prompt)
   set GOOGLE_API_KEY=your_actual_api_key
   ```

3. For Vertex AI, also set:
   ```bash
   export GOOGLE_CLOUD_PROJECT=your_project_id
   export GOOGLE_CLOUD_LOCATION=your_location
   export GOOGLE_GENAI_USE_VERTEXAI=true
   ```

### Best Practices

- NEVER commit API keys to version control
- Use environment variables or secure secret management
- Rotate your API keys periodically
- Restrict API key permissions to the minimum required

### Using .env Files (Optional)

If you prefer using a `.env` file:

1. Copy `.env.example` to `.env`
2. Add your API key to `.env`
3. Use a library like `dotenv` to load environment variables

**Warning:** Ensure `.env` is in your `.gitignore`

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

## Contribute to this library

The Google Gen AI Java SDK will accept contributions in the future.

## License

Apache 2.0 - See [LICENSE][license] for more information.

[gemini-api-doc]: https://ai.google.dev/gemini-api/docs
[vertex-api-doc]: https://cloud.google.com/vertex-ai/generative-ai/docs/learn/overview
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.genai/google-genai.svg
[maven-version-link]: https://central.sonatype.com/artifact/com.google.genai/google-genai/0.1.0
[license]: https://github.com/googleapis/java-genai/blob/main/LICENSE

# Google Generative AI Java SDK - How To Guide

## Prerequisites

1. **Java Development Kit (JDK)**
   - Ensure you have JDK 17 or later installed
   - Verify with: `java --version`

2. **Maven**
   - Install Maven (if not already installed)
   - Verify with: `mvn --version`

3. **Google AI Studio API Key**
   - Visit [https://aistudio.google.com/app/apikey](https://aistudio.google.com/app/apikey)
   - Create a new API key

## Setup

### 1. Set Up API Key

There are two ways to set your API key:

#### Option A: Environment Variable
```bash
export GOOGLE_API_KEY=your_actual_api_key_here
```

#### Option B: In .env File
Create or edit the `.env` file in the project root:
```
GOOGLE_API_KEY=your_actual_api_key_here
```

### 2. Project Structure

The main file for generating content is typically located at:
`src/main/java/com/google/genai/examples/GenerateContent.java`

### 3. Compilation and Execution

#### Compile the Project
```bash
mvn clean compile
```

#### Run the Project
```bash
# Option 1: Run with Maven
mvn exec:java -Dexec.mainClass="com.google.genai.examples.GenerateContent"

# Option 2: Skip Tests (if needed)
mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"
```

## Customizing Your Request

In the `GenerateContent.java` file, modify the `generateContent()` method:

```java
// Basic request
GenerateContentResponse response = 
    client.models.generateContent("gemini-2.0-flash-001", "Your prompt here", null);

// Example with more complex prompt
GenerateContentResponse response = 
    client.models.generateContent(
        "gemini-2.0-flash-001", 
        "Write a short poem about technology", 
        null  // Optional parameters
    );
```

## Troubleshooting

1. **API Key Issues**
   - Ensure your API key is correct
   - Check that it's properly set in the environment or .env file
   - Verify the key at [Google AI Studio](https://aistudio.google.com/app/apikey)

2. **Dependency Problems**
   - Run `mvn dependency:resolve` to download all required dependencies
   - Ensure you have an active internet connection

3. **Java Version Compatibility**
   - This project requires Java 17+
   - Use `--release 17` flag if you encounter module-related warnings

## Available Models

Common model names include:
- `gemini-2.0-flash-001`: Fast, lightweight model
- `gemini-2.0-pro-001`: More advanced model for complex tasks

## Best Practices

- Always handle potential exceptions
- Be mindful of API usage limits
- Protect your API key (never commit it to version control)

## Example Code Snippet

```java
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GenerateContent {
    public static void main(String[] args) throws Exception {
        // Instantiate the client
        Client client = new Client();

        // Generate content
        GenerateContentResponse response = 
            client.models.generateContent(
                "gemini-2.0-flash-001", 
                "Explain quantum computing in simple terms", 
                null
            );

        // Print the response
        System.out.println("AI Response: " + response.text());
    }
}
```

## License

This project is licensed under the Apache License 2.0. See the LICENSE file for details.

I'll create a comprehensive guide on how to compile and send a request to the Google Generative AI using Java. I'll edit the README.md file to include this information:

```markdown:README.md
# Google Generative AI Java SDK - How To Guide

## Prerequisites

1. **Java Development Kit (JDK)**
   - Ensure you have JDK 17 or later installed
   - Verify with: `java --version`

2. **Maven**
   - Install Maven (if not already installed)
   - Verify with: `mvn --version`

3. **Google AI Studio API Key**
   - Visit [https://aistudio.google.com/app/apikey](https://aistudio.google.com/app/apikey)
   - Create a new API key

## Setup

### 1. Set Up API Key

There are two ways to set your API key:

#### Option A: Environment Variable
```bash
export GOOGLE_API_KEY=your_actual_api_key_here
```

#### Option B: In .env File
Create or edit the `.env` file in the project root:
```
GOOGLE_API_KEY=your_actual_api_key_here
```

### 2. Project Structure

The main file for generating content is typically located at:
`src/main/java/com/google/genai/examples/GenerateContent.java`

### 3. Compilation and Execution

#### Compile the Project
```bash
mvn clean compile
```

#### Run the Project
```bash
# Option 1: Run with Maven
mvn exec:java -Dexec.mainClass="com.google.genai.examples.GenerateContent"

# Option 2: Skip Tests (if needed)
mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"
```

## Customizing Your Request

In the `GenerateContent.java` file, modify the `generateContent()` method:

```java
// Basic request
GenerateContentResponse response = 
    client.models.generateContent("gemini-2.0-flash-001", "Your prompt here", null);

// Example with more complex prompt
GenerateContentResponse response = 
    client.models.generateContent(
        "gemini-2.0-flash-001",  // Model name
        "Write a short poem about technology", 
        null  // Optional parameters
    );
```

## Troubleshooting

1. **API Key Issues**
   - Ensure your API key is correct
   - Check that it's properly set in the environment or .env file
   - Verify the key at [Google AI Studio](https://aistudio.google.com/app/apikey)

2. **Dependency Problems**
   - Run `mvn dependency:resolve` to download all required dependencies
   - Ensure you have an active internet connection

3. **Java Version Compatibility**
   - This project requires Java 17+
   - Use `--release 17` flag if you encounter module-related warnings

## Available Models

Common model names include:
- `gemini-2.0-flash-001`: Fast, lightweight model
- `gemini-2.0-pro-001`: More advanced model for complex tasks

## Best Practices

- Always handle potential exceptions
- Be mindful of API usage limits
- Protect your API key (never commit it to version control)

## Example Code Snippet

```java
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GenerateContent {
    public static void main(String[] args) throws Exception {
        // Instantiate the client
        Client client = new Client();

        // Generate content
        GenerateContentResponse response = 
            client.models.generateContent(
                "gemini-2.0-flash-001", 
                "Explain quantum computing in simple terms", 
                null
            );

        // Print the response
        System.out.println("AI Response: " + response.text());
    }
}
```

## License

This project is licensed under the Apache License 2.0. See the LICENSE file for details.
```
I've created a comprehensive README.md that covers everything from setup to advanced usage. Let me break down the key points for you:

### Key Steps to Compile and Send a Request

Let me break down the command you've shared:

1. `export GOOGLE_API_KEY=$(grep GOOGLE_API_KEY .env | cut -d '=' -f2)`:
   - This part reads the API key from the `.env` file
   - `grep GOOGLE_API_KEY .env`: Finds the line containing GOOGLE_API_KEY
   - `cut -d '=' -f2`: Splits the line at '=' and takes the second part (the value)
   - `export`: Sets the environment variable for the current shell session

2. `&&`: Ensures the next command runs only if the previous command succeeds

3. `mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"`:
   - `clean`: Removes previous build artifacts
   - `compile`: Compiles the source code
   - `exec:java`: Executes the specified Java class
   - `-DskipTests`: Skips running tests
   - `-Dexec.mainClass`: Specifies the main class to run

This is an efficient one-liner that:
1. Extracts the API key from the `.env` file
2. Sets it as an environment variable
3. Compiles the project
4. Runs the GenerateContent example without running tests

Would you like me to explain any part of the command in more detail?



1. **Prerequisites**:
   - Install JDK 17+
   - Install Maven
   - Get a Google AI Studio API Key

2. **Set Up API Key**:
   ```bash
   # Option 1: Environment Variable
   export GOOGLE_API_KEY=your_actual_api_key_here

   # Option 2: In .env File
   # Create/edit .env with: GOOGLE_API_KEY=your_actual_api_key_here
   ```

3. **Compile the Project**:
   ```bash
   mvn clean compile
   ```

4. **Run the Project**:
   ```bash
   # Basic run
   mvn exec:java -Dexec.mainClass="com.google.genai.examples.GenerateContent"
   ```

5. **Customize Your Request**:
   ```java
   // In GenerateContent.java
   GenerateContentResponse response = 
       client.models.generateContent(
           "gemini-2.0-flash-001",  // Model name
           "Your custom prompt here",  // What you want to ask
           null  // Optional parameters
       );
   ```

The README provides detailed explanations for each step, troubleshooting tips, and best practices.

Would you like me to elaborate on any part of the guide or show you how to modify the request to ask different questions?


I'll update the README.md to include this specific command:

```markdown:README.md
### 3. Compilation and Execution

#### Compile the Project
```bash
mvn clean compile
```

#### Run the Project
```bash
# Option 1: Run with Maven
mvn exec:java -Dexec.mainClass="com.google.genai.examples.GenerateContent"

# Option 2: Skip Tests (if needed)
mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"

# Option 3: One-Liner (Recommended): Extract API Key and Run
export GOOGLE_API_KEY=$(grep GOOGLE_API_KEY .env | cut -d '=' -f2) && mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"
```

#### Understanding the One-Liner Command
- `export GOOGLE_API_KEY=$(grep GOOGLE_API_KEY .env | cut -d '=' -f2)`: 
  - Extracts the API key from the `.env` file
  - Sets it as an environment variable
- `&&`: Ensures the Maven command runs only if API key extraction succeeds
- `mvn clean compile exec:java -DskipTests -Dexec.mainClass="com.google.genai.examples.GenerateContent"`: 
  - Cleans previous builds
  - Compiles the project
  - Runs the main class
  - Skips tests
```
I've added the one-liner command to the README.md with a detailed explanation of how it works. The new section provides:
1. The exact command
2. A breakdown of what each part of the command does
3. An explanation of why this is an efficient way to run the project

Is there anything else you'd like me to add or modify in the README?
