# British Spoken Time Converter
[![Java CI](https://github.com/avaiyahardik/time-spoken-app/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/avaiyahardik/time-spoken-app/actions/workflows/ci.yml)

A Spring Boot command-line application that converts time input in HH:MM format into its British spoken equivalent (e.g., 'quarter past five' or 'ten minutes to six').

## Example Conversions
- `00:00` → midnight
- `12:00` → noon
- `13:00` → one o'clock
- `13:15` → quarter past one
- `01:30` → half past one
- `13:45` → quarter to two
- `01:51` → nine to two

## Tech Stack
- Java 21 LTS – For modern, efficient runtime and features
- Gradle 8 – Build automation tool for dependency management and running tasks
- JUnit 5 & Mockito – For unit testing and mocking dependencies
- Jacoco – For generating code coverage reports

## Features
- Converts 24-hour time to British-style spoken time
- Includes a GitHub CI workflow to automatically build, test, and generate Jacoco code coverage reports
- Comprehensive and meaningful unit test cases ensuring the correctness of functionality
- Uses Factory and Strategy design patterns for extensible and clean design
- Clean, readable code adhering to Java Object-Oriented Programming best practices

## Prerequisites
### Before running the application, ensure that the following software is installed on your machine:
- Java 21 or later
- Gradle 8 or later

If you don't have Gradle installed locally, you can also use the Gradle wrapper, which is included in this repository.

## Build & Run

### Build the project
```bash
  ./gradlew build
```

### Run test cases
```bash
  ./gradlew test
```

### Generate Code Coverage Report
```bash
  ./gradlew jacocoTestReport
```
Once the report is generated, open it in your browser: `build/reports/jacoco/html/index.html`

### Run the project after build
```bash
  java -jar build/libs/time-0.0.1-SNAPSHOT.jar
```

## Example of running the command-line app:
```text
java -jar build/libs/time-0.0.1-SNAPSHOT.jar

Enter time in 24-hour format (HH:mm), or type 'exit' to quit:

Input time: 1:00
 → one o'clock

Input time: 2:05
 → five past two

Input time: 9:45
 → quarter to ten

Input time: 10:50
 → ten to eleven

Input time: 11:55
 → five to twelve

Input time: 00:00
 → midnight

Input time: 12:00
 → noon

Input time: exit
Exiting program. Goodbye!
```

## GitHub CI Actions
- The GitHub CI pipeline automatically runs tests and checks every time there’s a push to the main branch.
- [CI Status](https://github.com/avaiyahardik/time-spoken-app/actions)
