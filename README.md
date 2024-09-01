# Markdown Converter

## Overview

The Markdown Converter is a Spring Boot application designed to handle Markdown notes. It provides endpoints for saving Markdown notes, rendering them as HTML, and checking grammar. The application uses Java, Spring Boot, and integrates with various services for Markdown processing and grammar checking. 

## Features

- **Save Note**: Save a Markdown note along with its HTML conversion.
- **Render Note**: Retrieve the HTML version of a saved Markdown note.
- **Check Grammar**: Check the grammar of a given text.
- **Upload Files**: Upload files to the server.

## Technologies

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building the RESTful API.
- **PostgreSQL**: Database for storing notes.
- **JPA**: Java Persistence API for database operations.

## Getting Started

### Prerequisites

- Java 22
- Maven
- PostgreSQL

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/Pragadeesh-19/MarkdownNoteTaking.git
    cd MarkdownNoteTaking
    ```

2. **Configure the Database**

    Create a PostgreSQL database and update the `application.properties` file with your database credentials:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/markdown_converter
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. **Build and Run the Application:**

    Using Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Endpoints

- **Save Note**
  - `POST /api/notes/save` - Save a Markdown note. Requires a JSON body with `title` and `markdownContent`.

- **Render Note**
  - `GET /api/notes/render/{id}` - Retrieve the HTML version of a note by its ID.

- **Check Grammar**
  - `POST /api/notes/check-grammer` - Check the grammar of a given text. Requires a plain text body.

- **Upload File**
  - `POST /api/notes/upload` - Upload a file to the server. Requires a file in the request.

### Testing

Use Postman to test the API endpoints. Import the provided Postman collection (if available) for pre-defined tests.

### Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or enhancements.
