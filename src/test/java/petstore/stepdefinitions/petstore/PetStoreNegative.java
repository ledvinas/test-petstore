package petstore.stepdefinitions.petstore;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.actoractions.tasks.FindPetInStore;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static petstore.actoractions.tasks.AddPetToStore.addPetToStore;
import static petstore.models.builder.PetBuilder.withId;
import static petstore.stepdefinitions.SettingTheStage.Rocky;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="$DATADIR/petsnegative.csv", separator='|')
public class PetStoreNegative extends PetCSVSteps{

    @Test
    @WithTag("PetStore")
    public void negative_pet_store_test(){

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
