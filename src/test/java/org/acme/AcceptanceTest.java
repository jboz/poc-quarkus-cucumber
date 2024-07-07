package org.acme;

import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;

@CucumberOptions(features = "src/test/resources", glue = "org.acme")
public class AcceptanceTest extends CucumberQuarkusTest {

    public static void main(String[] args) {
        runMain(AcceptanceTest.class, args);
    }
}
