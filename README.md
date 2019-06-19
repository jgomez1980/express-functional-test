# express-functional-test

# Automation Express Project #


This project allows automation to support UI tests and services.
It implements good automation practices such as:

* PageObject pattern
* Cucumber for the use of Gherkins
* Tags of test cases
* Selenium


## Characteristics of the framework ##
 
 ** Support for build and deployment **
 
 * Apache Maven.
 
 * [Cucumber] (https://cucumber.io/)
     * Definition of scenarios.
     
 * [Selenium] (https://www.seleniumhq.org/)
     * Support for web automation.
         
 * For the creation of pages:
 [PageObject] (https://code.google.com/p/selenium/wiki/PageObjects)
 [PageFactory] (https://code.google.com/p/selenium/wiki/PageFactory)
 
 * Generation of reports of the executions.
     

## How to install the framework ##

To install the framework it is necessary to have certain prerequisites installed in our work environment:

* Git
* Maven
* Java
* IDE



### Git Installation ###

To install from Windows (https://git-scm.com/download/win)


### JDK Installation ###

Download and intstalar (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

To validate that JDK has been installed, enter the following command in the console:

java -version

### Maven Installation ###
 
Download Maven (http://maven.apache.org/download.cgi) and extract them to the selected folder.

* The JAVA_HOME environment variable must be set in the system path and point to the installation of our SDK.
* We add the bin directory of maven to the environment variable path.
* Confirm that it is installed correctly by executing the mvn -v command from the console.


### Set up the project for the first time ###

To configure the project for the first time we must navigate to the workspace where we want to have it, and once stopped there, from a console, execute Git to bring it from the repository:

~~~
git clone url_proyecto
~~~

Once the project has been cloned, we must install it so that maven downloads all the dependencies that we have defined in the pom.xml, for this we execute:

~~~
mvn install
~~~


### Installation Cucumber in Eclipse ###

In the case that Eclipse is used as IDE you will need to install a plugin from the Marketplace;

https://marketplace.eclipse.org/content/cucumber-eclipse-plugin
