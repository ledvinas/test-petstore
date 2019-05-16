package petstore.stepdefinitions;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;

public class SettingTheStage {

    EnvironmentVariables environmentVariables;

    public static Actor Rocky = Actor.named("Rocky");

    @Before
    public void setTheStage() {
        Rocky.whoCan(CallAnApi.at(environmentVariables.optionalProperty("baseUrl.petstore").orElse("")));
    }
}