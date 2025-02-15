package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src/test/java/feature/Login.feature"},
		dryRun = !true,
		glue = {"steps","hooks"},
		snippets =SnippetType.CAMELCASE,
		plugin = {"pretty",
				"html:reports/report.html",
				"json:reports/report.json",
				"junit:reports/report.xml"}
		//tags = "not @sanity"
		)
public class Runner extends AbstractTestNGCucumberTests{
	
	

}
