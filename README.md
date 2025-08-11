# ve3globaltest_seleniumtest Automation Framework

## Overview
This is a Selenium WebDriver based automation framework built with Java, TestNG, ApachePOI, following the Page Object Model (POM) design pattern. It supports data-driven testing using Excel file and generates reports using Allure.

## Tech Stack 
- Automation Tool : Selenium WebDriver
- Testing Framework: TestNG
- Build Tool: Maven
- Data Handling: Apache POI (for Excel handling)
- Design Pattern: Page Object Model
- Reporting: Allure Reports
- IDE: Eclipse

## Prerequisites
- Java JDK 17
- Eclipse
- Maven
- TestNG plugin
- ChromeDriver
- Git

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/gayatrithange/ve3global.git
   
2. Navigate to the project directory:
   cd ve3globaltest_seleniumtest

3. Install dependencies using Maven:
   mvn clean install

4. Run All Tests using Maven:
   mvn clean test

5. View allure report: 
   allure serve allure-results
