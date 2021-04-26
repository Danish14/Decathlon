# **Decathlon**

### This project contains the automation of following platform:
- Web
- Mobile

### Framework has been built using following tools and technologies:
- Java
- Maven
- Cucumber
- Gherkin

### Following is the architecture that has been followed for this project:

        - java
            - Platforms
                - platform(Web/Mobile)
                    - Pages(Web Pages/ Mobile Pages)
                        - Feature
                        - StepDefinition
                        - TestRunner
                    - Utilities
                        - Driver Actions
                        - Driver Factory
                        - Utilities
        - resources
            - drivers: Contains the drivers executable.
            - screenshots: Will contains the screenshots for web.
            - setupTest: Capabilities to set-up the platform.

### How To Run/Trigger A Test:
        Step 1: Install all maven dependencies and plugins.
        Step 2: Install required chrome/firefox drivers in resources > drivers.
        Step 3: Give the TestRunner class path in testng.xml file
        Step 4: Assign capabilities in src > test > resources > setupTest > setup-config.properties.(e.g. browser = chrome)
        Step 5: Right click on testng.xaml and click run.


    