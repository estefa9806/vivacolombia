package com.tcs.certificacion.vivaair.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions	(features ="src/test/resources/features/reservar_vuelo.feature",glue = "com.tcs.certificacion.vivaair.stepdefinition",snippets = SnippetType.CAMELCASE)
public class ReservarVueloRunner {

}
