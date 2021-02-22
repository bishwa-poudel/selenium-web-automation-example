<!-- PROJECT HEADER -->
<p align="center">
  <!--PROJECT TITLE AND DESCRIPTION -->
 <h1 align="center">Web Automation using Selenium Java</h1>

  <p align="center">
    A web automation project to ease daily attendance in my Office Intranet System built using Selenium in Java.
    <br /><br/>
    <a href="https://www.linkedin.com/in/bishwapoudel/">
        <img src="https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555"
            alt="follow on Twitter"></a>
    <a href="https://twitter.com/intent/follow?screen_name=_bishwapoudel">
        <img src="https://img.shields.io/twitter/follow/_bishwapoudel?style=for-the-badge&logo=twitter"
            alt="follow on LinkedIn"></a>

  </p>
</p>
<hr>

<!-- ABOUT THE PROJECT -->

## About The Project
This project explores Selenium as a Web Automation tool rather than UI Testing Tool. I have automated a task of daily attendance that I need to do in every working day before starting my office. Due to records of me missing attendance for multiple days, I wanted to automate this behavior, and finally succeeded.

![Web automation using Selenium](https://user-images.githubusercontent.com/16562819/108623847-4a304e80-7469-11eb-965e-13b8efdce54e.png)

Feels good waking up to this log every morning 😂


### Built With
* [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) as programming language
* [Maven](https://maven.apache.org/) for Package Management and Build Automation
* [Selenium](https://www.selenium.dev/) for Web Automation
* [Resteasy](https://resteasy.github.io/) as JAX-RS implementation for Restful Services 

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites
  Basic understanding of Java with Maven.

### Running the project
Steps are listed below to get this project up and running in your development environment.
* Setup Java with JDK 1.8. For reference: Use this official [Tutorial](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm)
* Setup Maven. Follow this link: [Maven Setup](https://maven.apache.org/install.html) 
* Clone this repository in your target folder.
```
git clone https://github.com/bishwa-poudel/selenium-web-automation-example.git
```
* Now go to `src/main/resources-filtered/intranet.sample.properties` and rename the configuration file to `intranet.properties`. Also, give your LIS Intranet credentials in properties file.

Example:
```
# file: intranet.properties
#**************************** LIS Intranet Creds *************************

INTRANET_USERNAME=username     # Your username
INTRANET_PASSWORD=password     # Your password
```

* Finally run maven build command:

```
mvn clean install
```

![image](https://user-images.githubusercontent.com/16562819/108626213-270c9b80-7477-11eb-8988-d36f9f60f0fc.png)

* Once you see this message in the console, your build is ready. Goto `target/lis-intranet-automation.war}` to get the archived file.

_Note: I have used WAR for packaging. If you want to build into the jar file, change the `<packaging>` inside pom.xml file to jar._

```
 <packaging>jar</packaging>
```

Now you can use any application server to deploy the archived java file. For this project I am using [Wildfly v22.0.1](https://www.wildfly.org/) 

Congrats !!! You are now able to run the project in your own development environment. 

## Usage
Server automatically schedules intranet check in and check out time for the next day in every restart. There is also APIs exposed for manual check in and check out.

### For Manual Check in
```http
GET /lis-intranet-automation/api/action/checkin
```

### For Manual Checkout
```http
GET /lis-intranet-automation/api/action/checkout
```

## Authors

* **Bishwa Poudel** - *Initial work* - [Bishwa Poudel](https://github.com/bishwa-poudel)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


## Contact
[![LinkedIn][linkedin-shield]][linkedin-url] [![Twitter][twitter-shield]][twitter-url]

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/bishwapoudel/
[twitter-shield]: https://img.shields.io/twitter/url/https/twitter.com/cloudposse.svg?style=for-the-badge&logo=twitter&colorB=555&label=Twitter
[twitter-url]: https://twitter.com/_bishwapoudel
