# Android
Java project for mobile app automated testing

# Platform
Android

# Stack
```
Java
Maven
TestNG
Appium
Allure
```

# Preconditions
1. Install Java 8
2. Install Maven
3. Set environmental variables **JAVA_HOME**, **JRE_HOME**, **MAVEN_HOME**, **ANDROID_HOM**E (for android emulator)
4. Set driver capabilities in [MobileDriver.java](https://github.com/MariyaMitko/android/blob/master/src/test/java/mitsko/mobile/automation/android/driver/MobileDriver.java)

# Configurations
To install dependencies from **pom.xml** run command (in the root directory of the project)
```
mvn clean install
```

# Run tests
To run single test run command
```
mvn test -Dtest={path_to_test_class}
```

To run full test suite run command
```
mvn clean test
```
or
```
mvn -Dtests=testng.xml test
```

# Create report
To create allure report make sure that there is a **allure-results** folder with testing results in **target** directory. Then run command
```
mvn io.qameta.allure:allure-maven:serve
```
