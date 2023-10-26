# Customer Microservice

This is a Spring Boot-based customer microservice that allows you to register customers, find customers by ID, and retrieve all customers.

## Dependencies

The following dependencies are used in this project:

- **spring-boot-starter-data-jpa**: Spring Boot starter for using Spring Data JPA with Hibernate.
- **spring-boot-starter-web**: Spring Boot starter for building web applications, including RESTful applications, using Spring MVC.
- **spring-boot-starter-validation**: Spring Boot starter for validation, including Hibernate Validator and JSR-303 support.
- **h2**: Lightweight, in-memory database for development and testing purposes.
- **lombok**: Project Lombok, a library that simplifies Java development by providing annotation-based code generation for common boilerplate code, such as getters, setters, constructors, and more.
- **spring-boot-starter-test**: Spring Boot starter for testing, including TestNG, JUnit, Mockito, AssertJ, and more.

## Project API

This API provides functionalities related to customer management. It allows you to fetch customer details, register new customers, and search for customers by their IDs.
``` yaml
openapi: 3.0.1
info:
  title: OpenAPI definition
  version: v0
servers:
- url: http://localhost:8080
  description: Generated server url
paths:
  /api/customers:
    get:
      tags:
      - customer-controller
      operationId: findAllCustomers
      responses:
        "200":
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Customer'
    post:
      tags:
      - customer-controller
      operationId: registerCustomer
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CreateCustomerCommand'
        required: true
      responses:
        "200":
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Customer'
  /api/customers/{customerId}:
    get:
      tags:
      - customer-controller
      operationId: findCustomerById
      parameters:
      - name: customerId
        in: path
        required: true
        schema:
          type: string
          format: uuid
      responses:
        "200":
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Customer'
components:
  schemas:
    CreateCustomerCommand:
      required:
      - personalInformation
      type: object
      properties:
        personalInformation:
          $ref: '#/components/schemas/PersonalInformation'
    PersonalInformation:
      required:
      - address
      - identificationNumber
      - name
      - surname
      type: object
      properties:
        name:
          maxLength: 50
          minLength: 2
          type: string
        surname:
          maxLength: 50
          minLength: 2
          type: string
        secondSurname:
          type: string
        address:
          type: string
        identificationNumber:
          type: string
    Customer:
      type: object
      properties:
        id:
          type: string
          format: uuid
        personalInformation:
          $ref: '#/components/schemas/PersonalInformation'
        status:
          type: string
          enum:
          - VALID
          - INVALID
          - BLOCKED


```
