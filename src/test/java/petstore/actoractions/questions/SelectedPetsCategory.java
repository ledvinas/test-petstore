package petstore.actoractions.questions;

import net.serenitybdd.screenplay.Question;
import petstore.models.Pet;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class SelectedPetsCategory {

    public static Question<Boolean> hasCategoryId(Long categoryId){
        return a -> lastResponse().getBody().as(Pet.class).getCategory().getId().equals(categoryId);
    }

    public static Question<Boolean> hasCategoryName(String categoryName){
        return a -> lastResponse().getBody().as(Pet.class).getCategory().getName().equals(categoryName);
    }
}
