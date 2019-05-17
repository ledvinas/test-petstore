package petstore.stepdefinitions.petstore;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.actoractions.tasks.FindPetInStore;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static petstore.actoractions.tasks.AddPetToStore.addPetToStore;
import static petstore.models.builder.PetBuilder.withId;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="$DATADIR/petsnegative.csv", separator='|')
public class PetStoreNegative extends PetCSVSteps{

    EnvironmentVariables environmentVariables;

    @Test
    @WithTag("PetStore")
    public void negative_pet_store_test(){

        Actor Rocky = Actor.named("Rocky")
                .whoCan(CallAnApi.at(environmentVariables.optionalProperty("baseUrl.petstore").orElse("")));

        //Given
        Rocky.attemptsTo(addPetToStore(withId(this.getPetId())
                .withName(this.getPetName())
                .withCategory(this.getCategory())
                .withPhotoUrls(this.getPhotoUrls())
                .withTags(this.getTags())
                .andStatus(this.getStatus())));

        Rocky.should(seeThatResponse(response -> response.statusCode(200)));

        //When
        Rocky.attemptsTo(FindPetInStore.byId(this.getPetId()));

        //Then
        Rocky.should(seeThatResponse(validateResponse -> validateResponse.statusCode(404)));
    }
}
