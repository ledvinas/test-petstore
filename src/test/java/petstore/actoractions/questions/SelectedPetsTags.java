package petstore.actoractions.questions;

import net.serenitybdd.screenplay.Question;
import petstore.models.Pet;
import petstore.models.Tag;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class SelectedPetsTags {

    public static Question<Boolean> haveTags(List<Tag> tags){
        return a -> lastResponse().getBody().as(Pet.class).getTags().containsAll(tags);
    }
}
