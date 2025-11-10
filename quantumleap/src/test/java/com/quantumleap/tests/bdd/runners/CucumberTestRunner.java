package com.quantumleap.tests.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.quantumleap.tests.bdd.steps"},
        plugin = {"pretty", "summary"},
        tags = "@add_to_cart"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests { }
