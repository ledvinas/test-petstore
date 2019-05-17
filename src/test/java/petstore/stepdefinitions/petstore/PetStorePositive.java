package petstore.stepdefinitions.petstore;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.actoractions.questions.SelectedPet;
import petstore.actoractions.questions.SelectedPetsCategory;
import petstore.actoractions.questions.SelectedPetsTags;
import petstore.actoractions.tasks.FindPetInStore;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static petstore.actoractions.tasks.AddPetToStore.addPetToStore;
import static petstore.models.builder.PetBuilder.withId;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="$DATADIR/pets.csv", separator='|')
public class PetStorePositive extends PetCSVSteps {

    EnvironmentVariables environmentVariables;

    @Test
    @WithTag("PetStore")
    public void add_pet_test_positive(){

        //Given
        Actor Rocky = Actor.named("Rocky")
                .whoCan(CallAnApi.at(environmentVariables.optionalProperty("baseUrl.petstore").orElse("")));

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
        Rocky.should(seeThatResponse(response -> response.statusCode(200)),
                seeThat("has id",SelectedPet.hasPetId(this.getPetId())),
                seeThat("has name", SelectedPet.hasName(this.getPetName())),
                seeThat("has photo urls", SelectedPet.hasPhotoUrls(this.getPhotoUrls())),
                seeThat("has has status",SelectedPet.hasStatus(this.getStatus())),
                seeThat("has category id",SelectedPetsCategory.hasCategoryId((long)this.getCategoryId())),
                seeThat("has category",SelectedPetsCategory.hasCategoryName(this.getCategoryName())),
                seeThat("has pet tags",SelectedPetsTags.haveTags(this.getTags()))
        );
    }
}
