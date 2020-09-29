package Runner1;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="Registration12/Signup.feature",
				glue= {"StepDefinition01"},
				plugin= {"json:target/json-report.json","html:target/test-report","junit:target/junit-xml-report.xml"}
				)

public class Test_Runner {
	
}
