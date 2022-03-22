## Subscription service coding challenge

### Problem

We need a service to manage the many subscription types we have. In our company, a subscription consists of:

* A name (not empty, maximum of 300 characters)
* A price (a currency value). If not manually set on the subscription, we should calculate it using the feature default
  price
* A list of features

A feature consists of:

* a service code, one of the possible codes (CIRCLES, TASKS)
* A default price

### API

The service should expose http REST endpoints that allows for subscription and feature CRUD (Create, Read, Update and
Delete)

### Non Functional requirements

* Service should be build with Java or Kotlin
* Should contain full test coverage

