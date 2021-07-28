package stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
        glue={"stepdefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/html-reports/report.html",
                "json:target/json-reports/report.json",
                "junit:target/xml-reports/report.xml"
        },
        tags = "@smoke")
public class TestRunner {

}
