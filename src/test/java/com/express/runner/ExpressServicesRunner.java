package com.express.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

	features = { "src/test/java/com/supervielle/features/ServicesFeatures" },

	glue = { "com.supervielle.stepDefinitions" },

	tags = { "@Servicios" },

	plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },

	monochrome = true)

public class ExpressServicesRunner {

}
