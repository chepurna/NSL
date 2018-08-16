package org.learning.selecucumrunner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class) //This line is for JUnit

@CucumberOptions(
		features = {"./src/test/resources/features/ShoppingHome.feature"}
		,plugin = {"pretty"}	
		,glue={"org.learning.selecucumone"}
		)

//@Test
public class TestRunnerDemo{} // This line is for TestNG
//public class TestRunnerDemo{}