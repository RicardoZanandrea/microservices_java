# Testing Microservices

---
## Prerequisites

Before you begin, ensure you have the following installed:
* Java Development Kit (JDK) 17 or later
* Apache Maven

---
## How to Run

1.  **Clone the repository**
    ```bash
    git clone https://github.com/RicardoZanandrea/microservices_java.git
    ```

2.  **Navigate to the project directory**
    ```bash
    cd microservices_java
    ```

3.  **Run the application**
    This command will start the web server on `http://localhost:8080`.
    ```bash
    ./mvnw spring-boot:run
    ```

---
## Testing the Endpoints 🚀

You can test the service using any API client or the `curl` command in your terminal. The service supports an optional **name** (provided either in the URL path or as a query parameter) and a `lang` query parameter for the language.

### Basic Greetings (Default: English)

* **Get the default greeting**
    ```bash
    curl "http://localhost:8080/greeting-service"
    ```
    **Expected Output:**
    ```
    Hello, World!!
    ```

* **Provide a name in the URL path**
    ```bash
    curl "http://localhost:8080/greeting-service/Agni"
    ```
    **Expected Output:**
    ```
    Hello, Agni!!
    ```

### Multilingual Greetings

You can get a greeting in a different language by adding the `?lang=` query parameter. Supported languages are `en` (English), `ja` (Japanese), and `pt-BR` (Brazilian Portuguese).

* **Get the default greeting in Japanese**
    ```bash
    curl "http://localhost:8080/greeting-service?lang=ja"
    ```
    **Expected Output:**
    ```
    こんにちは, 世界!!
    ```

* **Get a custom greeting in Portuguese using query parameters**
    ```bash
    curl "http://localhost:8080/greeting-service?name=Agni&lang=pt-BR"
    ```
    **Expected Output:**
    ```
    Fala, Agni!!
    ```

* **Get a custom greeting in Japanese using query parameters**
    ```bash
    curl "http://localhost:8080/greeting-service?name=Agni&lang=ja"
    ```
    **Expected Output:**
    ```
    こんにちは, Agni!!
    ```
