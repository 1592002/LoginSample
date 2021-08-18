package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/vamsi/eclipse-workspace/LoginSample/src/test/java/loginPage",
glue= {"stepDefinition"},monochrome=true,
plugin = { "pretty",  "html:target/reports/htmlReport.html",
		})
		

public class TestRunner {

}
