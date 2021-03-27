# BoxAuto
This repository is a test task for Box.com to automate the smoke functional test cases for the application.

## Test scenarios automated
Below are the test cases that have been automated as part of this exercise

 * Login and logout scenario.
 * Login with invalid credentials.
 * Create,rename and delete a folder
 * Upload,rename and delete a file
 * Upload and delete a file from/to an existing folder.
 * Create,rename and delete a new collection
 * Add a folder to an existing collection

**Note**: Search functionality is not working on box.com. Hence can't be automated

## Tech Stack
Below are the tools and libraries utilizid within this framework

* Java1.8 (Code written in Java)
* **Build tool** - Apache Maven 3.6.3 (Maven CLI to be installed by default in order to run tests. Can be downloaded from https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/)
* **Web Automation tool** : Selenium 3.14
* **BDD library** : Cucumber 4.1
* **Reporting tool** : Allure report 2.7.0 (To launch report on a standalone http server download allure cli interface from https://github.com/allure-framework/allure2/releases)
* **Test framework** : Testng 7.0

## How To Run

1. Clone the current repository to your local machine
 `git clone https://github.com/geekyPiyush/BoxAuto.git`

2. Goto the new repo folder 'BoxAuto'

3. Switch to master branch
   `git checkout master`

4. Note: Install maven and allure cli if not already done. 

5. Run the following basic command to trigger all cucumber scenarios in the test suite

   `mvn clean test -P chrome -Dcucumber.options="--tags @functional"`
   
### Breakdown of above test command
   
   1. **mvn clean test** : Maven lifecyle phase to run surefire tests after cleaning the project
   2. **-P chrome** : Profile to run - Currently it is chrome, means the tests would be running in chrome browser. Other value accepted is **firefox**
   3. **-Dcucumber.options="--tags @functional"** : Tags to run in cucumber. Can accept any other tags present in the feature files. Other value accepted is         **@login,@files,@folder,@collections**

6. You can also pass the credentials for logging into the box account via above command line as follows

   `mvn clean test -P chrome -Dcucumber.options="--tags @functional" -Dusername="<box_username>" -Dpassword="<box_password>"`
   
    However, as part of the basic command you don't need to pass credentials as they are already configured under `/src/main/resources/config/env-properties/live.json`
    
7. Once you run above test command, the tests would execute in sequential mode and the logging is progressive for now i.e (dots to represent test progress). 

8. Once tests are completed with pass/fail, at the end **allure-reports** would be generated under `BoxAuto/allure-reports/box` folder

9. In order to view the allure-reports there are two options

   1. Download allure command line tool as mentioned in Tech Stack section. Once done, run the below command from CLI
      `allure open BoxAuto/allure-reports/box`
      
      ![image](https://user-images.githubusercontent.com/72020821/112713045-006bd580-8ef9-11eb-9654-ed0b5a3c2aa8.png)
      
      This will launch the report on a static http server and open it in default browser
      
   2. Goto `BoxAuto/allure-reports/Box/` and ooen the index.html in browser to view report
 
## Report view

Report generated for running 2 login tests out of which 1 failed

![image](https://user-images.githubusercontent.com/72020821/112713128-8daf2a00-8ef9-11eb-824e-5439cfcd1002.png)

* Overview shows the dashboard about the total tests run and failed/passed
* Click on Suites from left bar and view the individual scenarios. Failed are marked in read and passed in green
* Click on any failed scenario and details about the scenario would open in right panel
* Scroll down till Tear down method of failed test scenario. Expand it and sceenshot of failed area would be attached

![image](https://user-images.githubusercontent.com/72020821/112713176-f0082a80-8ef9-11eb-85e0-753bdfcb93e0.png)

## Framework Architecture

BoxAuto is built upon as a Maven project hence all the Helpers and factory methods goes in `/src/main` and all the test features and resources goto `src/test`

* `src/main/java` comprises of 
   * all the Helpers methods for element operations on the screen
   * The Drivers package dealing with loading the browser,dimensions and related drivers
   * Factory package deals with core logic for critical operations in the system.
   * Hooks package for taking screenshot after scenario fails
   * Loaders for loading appropriate json files into memory
   * Loggers for formatted logging purpose
   * state for maintaing common state across steps.
   * resources comprising of 
      1. common configurations such as desktop_browser properties and live.json
      2. test data files for uploading purpose in application
      3. testng xml files 
      4. browser driver for chrome and firefox

* `src/test/java` comprises of
   * Constants containing the page locators.
   * PageObjects for creating webelements out of locators.
   * Steps having functional step definitions for every area
   * TestRunner file or testng runner file
   * resources comprising of ** Feature files ** for every functionality


 
   
  
   
