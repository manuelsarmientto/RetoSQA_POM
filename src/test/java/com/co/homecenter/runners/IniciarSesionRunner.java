package com.co.homecenter.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@inicioSesion",
        glue = "com.co.homecenter.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)

public class IniciarSesionRunner {
}
