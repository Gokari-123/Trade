# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web.security)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Who to run This Api for  Create a User

1 POST
Url : http://localhost:8080/users1

Json Body

{
"userId": "bhai@domain.com",
"password": "bhai@123"
}

### 2 GET TRADES ALL 
Url : http://localhost:9000/trades

In Authorization 
UserName anna@domain
password anna@123

Response
{
"id": 1,
"quantity": 100,
"price": 1500.75,
"buysell": "buy",
"asset_type": "Equity",
"origin_country": "JP",
"user": {
"userId": "Hussain@domain.com",
"password": "$2a$10$0FMFhcunhw5.YJ8SDf3miunwms3kCzDq0NvigUCCYafMgQZTiIs6m"
},
"currency": "JPY"
},
{
"id": 2,
"quantity": 200,
"price": 20000.75,
"buysell": "buy",
"asset_type": "Equity",
"origin_country": "JP",
"user": {
"userId": "mahaboob@domain.com",
"password": "$2a$10$KTTCW1WszHjZ9nIZXxQAxO1Q09jT2TGbvVH3EszT51sFlasuqCBeW"
},
"currency": "JPY"
}
]

### 3 Create A trades using POST API

Url localhost:9000/trades
In Authorization
UserName anna@domain
password anna@123

Request Body
{
"quantity": 300,
"price": 3500.50,
"currency": "JPY",
"buysell": "Buy",
"asset_type": "Equity",
"origin_country": "JP",
"user": {
"userId": "anna@domain.com"
}
}




