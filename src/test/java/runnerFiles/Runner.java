package runnerFiles;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/java/featureFiles"} ,
	glue = {"stepDefinitionsFiles"},
	monochrome  = true,
	publish = true  

	)


public class Runner {

}
