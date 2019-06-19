package com.express.runner;
//package com.supervielle.runner;
//
//import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//
//
//@RunWith(Cucumber.class)
//
//@CucumberOptions(
//
//        features = { "src/test/java/com/supervielle/features/OnboardingUIFeatures" },
//
//        glue = { "com.supervielle.stepDefinitions" },
//
//        tags = { "@Regression1" },
//
//        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
//                "html:target/cucumber-reports",
//                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
//
//        monochrome = true)
//
//public class OnboardingUIRunnerParallel extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] features() {
//        return super.features();
//    }
//
//}
