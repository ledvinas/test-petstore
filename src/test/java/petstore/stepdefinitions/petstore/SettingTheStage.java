package petstore.stepdefinitions.petstore;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
public class SettingTheStage {

    EnvironmentVariables environmentVariables;

    public static Actor Rocky = Actor.named("Rocky");

    @Before
    public void setStage() {
        Rocky.whoCan(CallAnApi.at(environmentVariables.optionalProperty("baseUrl.petstore").orElse("")));
    }
}