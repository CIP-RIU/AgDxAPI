# Crop Pest and Disease Data API (AgDxAPI)

## Background

AgDx is a newly formed alliance initiated by several CGIAR centers, PlantVillage and EDDMaps which are publicly funded, non-profit organizations dedicated to research for development and education in agriculture with the aim to improve plant health globally through ICT tools.

As an alliance of individual platforms, tools and databases aimed at supporting agricultural health in different aspects, AgDx has committed to address these shortcomings through the development of Application Program Interfaces (API&#39;s) to facilitate sharing of data between platforms and/or by providing links between complementary ICT tools where appropriate.

To initiate this process, minimum data elements for exchange between alliance databases and applications are determined, and harmonize these with existing data standards and ontologies to develop and document a standardized web service API specification.

## Objectives:

Create data exchange standards, and a REST API (dubbed AgDxAPI) for plant pest and disease data held in disparate databases and applications.

Collaboration among a community of developers of pest and disease databases and applications and the CGIAR Platform on Big Data in Agriculture.

It will build on existing data standards for Agriculture, such as the Crop and Agronomy ontologies.

## Tasks

1. Review data structures in existing pest and disease databases and applications and recommend a minimum set of data for interoperability and exchange.
2. Participate in requirements gathering via agile methodologies to define functional and non-functional requirements.
3. Review existing data definition standards and ontologies from the CGIAR, Academia, and development organizations like FAO for reuse in defining data exchange attributes for the AgDxAPI.
4. Create a draft version of the **AgDxAPI** standardized web service API specification for data exchange.
5. Lead the review of the specification in a (virtual) workshop of all stakeholders. The workshop will provide feedback and provide input for the finalization of the first version of the specification.
6. Document the **AgDxAPI** using widely accepted API documentation standards

## Deliverables

1. List of minimum data elements suitable for exchange between the pest and disease databases and applications
2. Harmonization of the minimum data elements with existing data standards and ontologies
3. **AgDxAPI** standardized web service API specification published on the AgDx Alliance Github
4. Documentation of the **AgDxAPI** including on online API documentation systems such as Apiary and Swagger

---

## Dependencies

- JDK 15

## Tools used

---

# Development setup

---

## Setup IntelliJ
Install Spring assistant to help in springboot config processing and code autocompletion
[**Install Spring Assistant**](https://plugins.jetbrains.com/plugin/10229-spring-assistant/)
option.

##### Environment variables
To switch the environment in dev mode adjust these basic parameters
```
SPRING_PROFILES_ACTIVE=dev;DB_URL=jdbc:postgresql://localhost:5432/postgres;DB_USER=user;DB_PASS=pass
``` 

## Migration 
### Generate Liquibase changelog file
```bash
 ./gradlew migrations:generateChangelog  -PchangeName="Name of Changelog"
```

example:
```bash
 ./gradlew migrations:generateChangelog -PchangeName="Create Users table"
```

The author defaults to the user currently running the command on the system. Optionally, you can use a different author
by adding the `-Pauthor` argument:


```bash
./gradlew migrations:generateChangelog -PchangeName="Create Users table" -Pauthor="The Stig"
```

> Remember to add the changelog file to the `changelog.xml` file

### To override default java version without messing with your machine paths and ENV

Create a file in the root of the project `gradle.properties` then paste your jDK path `org.gradle.java.home=C:\\Program Files\\OpenJDK\\jdk-14.0.2`
Change the path according to your JDK installation

## API Explorer
### Swagger
To explore the api endpoints refer to this link (just for reference requests might not get sent due to security restrictions)
[**Swagger UI**](https://app.swaggerhub.com/apis/masgeek/agdxapi/1.0.0)
option.

### Apiary
