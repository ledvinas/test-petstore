package petstore.stepdefinitions.petstore;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.WithTag;
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
import static petstore.stepdefinitions.SettingTheStage.Rocky;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="$DATADIR/pets.csv", separator='|')
public class PetStorePositive extends PetCSVSteps {

    @Test
    @WithTag("PetStore")
    public void add_pet_test_positive(){

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
        Rocky.should(seeThatResponse(response -> response.statusCode(200)),
                seeThat(SelectedPet.hasPetId(this.getPetId())),
                seeThat(SelectedPet.hasName(this.getPetName())),
                seeThat(SelectedPet.hasPhotoUrls(this.getPhotoUrls())),
                seeThat(SelectedPet.hasStatus(this.getStatus())),
                seeThat(SelectedPetsCategory.hasCategoryId((long)this.getCategoryId())),
                seeThat(SelectedPetsCategory.hasCategoryName(this.getCategoryName())),
                seeThat(SelectedPetsTags.haveTags(this.getTags()))
        );
    }
}
