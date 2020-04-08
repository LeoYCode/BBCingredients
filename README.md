<h1>JVM Dependency Injection with Spring</h1>

This is an example maven framework project demonstrating, the use of Springs dependency injection with Selenium-Webdriver and JUnit.

<h2>Intro</h2>
The purpose of this repo is to demonstrate how Selenium-Webdriver tests can be written in a way as to be implementation agnostic, achieving this using dependency injection.

<h2>Usage</h2>
To run with Chrome or Firefox browser:<br/>
```
mvn clean test -Dselenium.Browser=chrome
```


<h2>Tested</h2>
Framework was tested on 8th April 2020:

* Macbook Pro 13" 2019
* macOS 10.15.3 (19D76)
* Maven 10.15.3
* Java openjdk 11.0.1 2018-10-16
* Chrome for Mac 80.0.3987.149 (Official Build) (64-bit)

Assumptions:
* BBC have not made any changes to their recipes pages.
