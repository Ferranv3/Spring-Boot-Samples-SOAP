# Demo API SOAP application using Java Spring Boot Framework
It contains a Spring Boot back-end with many endpoints. A calculator, a Nasa image viewer using an API Rest, a contact form and a collection of beers using an API Rest.

## API SOAP
There is a PostMan collection file exported in root folder. You can import to easily testing countries and customers API.

#### Endpoint
* http://localhost:8080/ws

## Run Docker container
Install docker in your computer and run in root folder:
* docker build -t demoapp .
* docker run -p 8080:8080 demoapp

## How to run in Windows
Install scoop or cholocatey in Windows to easily the process.

### Instalar OpenJDK:
* scoop install openjdk17
* choco install openjdk17

to verify use command: javac --version

### Install Maven
* scoop install maven
* choco install maven

to verify use command: mvn --version

## Run:
* Execute this order in root project folder -> .\mvnw spring-boot:run
* Maven cleaning -> mvn clean