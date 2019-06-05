package ej.Module;
import cucumber.api.Scenario;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
features = {"src/test/resources/Login.feature"},

tags={"@SmokeTest"}
)

public class runTest {
	
}

/*
@RunWith(Cucumber.class) 
@CucumberOptions.Options(format = {"pretty", "html:target/html"},
features = {"FeatureCollections"},
tags={"@SmokeTest"}
	) 
public class runTest {

}
*/
