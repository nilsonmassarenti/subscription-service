# Subscription Service

Subscription service is a example of rest service with restful integrations. This project contains:
  - Subscription Service - Main Project 
  - Mock Services - Interface to test the main project

# New Features!

  - Create subscription - /api/v1/subscriptions
  - Mock - Examples of event and emailo

You can also:
  - Import and save files from GitHub, Dropbox, Google Drive and One Drive
  - Drag and drop markdown and HTML files into Dillinger
  - Export documents as Markdown, HTML and PDF

### Tech

Dillinger uses a number of open source projects to work properly:

* [Spring] - Main Java Framework
* [H2] - Database

### Installation

Subscription requires [Maven](https://maven.apache.org/) to run 

If you will use the mock.
Install the dependencies and start the mock server. http://localhost:8081

```sh
$ cd mock-service
$ mvn clean install
$ mvn spring-boot:run
```

However, if you are using Docker, execute thses commands:

```sh
$ cd mock-service
$ mvn clean install
$ docker build -f Dockerfile -t mock-service .
$ docker run -p 8081:8081 mock-service
```

if you won't use mock service, you need to change application.properties. Options available are:
  - Database - H2 to your database
  - Datasource - Configuration to your datasource
  - Mock Services - Configuration to your servers

Install the dependencies and start the Subscription server.http://localhost:8080

```sh
$ cd subscription service
$ mvn clean install
$ mvn spring-boot:run
```

However, if you are using Docker, execute these commands:

```sh
$ cd subscription service
$ mvn clean install
$ docker build -f Dockerfile -t subscription service .
$ docker run -p 8080:8080 subscription service
```

Swagger Available
 - JSON - http://localhost:8080/v2/api-docs
 - UI - http://localhost:8080/swagger-ui.html
