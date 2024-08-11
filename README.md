
# Web Testing with Java and Selenium

This repository contains automation scripts for web testing using **Java** and **Selenium WebDriver**. The project is designed to help QA engineers and developers get hands-on experience with Selenium, a powerful tool for automating web browsers.

## Features

- **Cross-browser testing**: Scripts are designed to work across multiple browsers (Chrome, Firefox, etc.)
- **TestNG Integration**: Use of TestNG framework for test management, parallel test execution, and reporting.
- **Page Object Model (POM)**: Implementation of POM to enhance maintainability and reusability of code.
- **Data-Driven Testing**: Use of external data sources (e.g., Excel) for running tests with multiple sets of data.
- **Screenshots on Failure**: Capture screenshots automatically when a test fails.

## Project Structure

- **src/main/java**: Contains the main Java files, including the Page Object Models and utility classes.
- **src/test/java**: Contains the test scripts using TestNG.
- **resources**: Includes configuration files, test data, and other resources needed for the tests.

## Prerequisites

- **Java Development Kit (JDK)** - Version 8 or higher.
- **Maven** - For managing dependencies and building the project.
- **Selenium WebDriver** - Included as a Maven dependency.
- **TestNG** - Included as a Maven dependency.

## Setup Instructions

1. **Clone the Repository**
    ```bash
    git clone https://github.com/ahmeddola20/Web_Testing_java-selenium.git
    cd Web_Testing_java-selenium
    ```
2. **Install Dependencies**
    - Ensure Maven is installed on your machine.
    - Run the following command to install all necessary dependencies:
    ```bash
    mvn clean install
    ```
3. **Run Tests**
    - Execute the following Maven command to run the tests:
    ```bash
    mvn test
    ```

## Contributing

Contributions are welcome! Feel free to fork this repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

- **Ahmed Dola** - [GitHub Profile](https://github.com/ahmeddola20)

For any queries or support, feel free to open an issue or contact the author.

