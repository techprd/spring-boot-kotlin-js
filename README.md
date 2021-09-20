# Spring Boot Kotlin js Project

This project is an application skeleton for a full-stack spring boot app written entirely with Kotlin.

## Spring Boot Server side and UI component written with Kotlin

### Full Tutorial coming soon

<a href="https://techprd.com/spring-boot-kotlin-js-demo-project/">Spring Boot app with Kotlin and Kotlin.js</a>

### What's in this project?

1. spring-boot app to run server
2. Kotlin js to write UI components
3. Kotlin Dependencies
4. gradle to build/compile/transcompile kotlin

### How to Use:

#### Development

#### Run Spring Boot Server

`$ ./gradlew bootRun`

#### Run web-pack dev server with continues reload

`$ ./gradlew jsBrowserDevelopmentRun -t`

#### Build project

###### On Windows

`$ gradlew.bat build`

###### On Linux / Mac

`$ ./gradlew build`

once the build is finished then the final "fat-jar"
will be inside a zip file including a script to run it:
build/distributions/springboot-kotlin-js-boot-2.5.4.zip

### Project structure

This project consists of:

- jvmMain
    - this is where server-side springboot implementation exists
- jvmTest
    - springboot tests goes here
- commonMain
    - consists of shared implementations between back-end and front-end
    - do not include any secrets in this module as it is share with front-end
- commonTest
    - common tests
- jsMain
    - this is the front-end module that renders the single page application
- jsTest
    - front-end browser tests goes here

#### Kotlin official site

https://kotlinlang.org
https://kotlinlang.org/docs/reference/js-overview.html

