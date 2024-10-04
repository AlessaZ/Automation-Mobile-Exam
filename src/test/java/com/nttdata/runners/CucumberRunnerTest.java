package com.nttdata.runners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.nttdata.stepDefinitions",
        tags = "@AddProductSuccess"
)
public class CucumberRunnerTest {

}
