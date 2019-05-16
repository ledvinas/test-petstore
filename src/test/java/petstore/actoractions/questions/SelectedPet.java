package petstore.actoractions.questions;

import net.serenitybdd.screenplay.Question;
import petstore.models.Pet;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class SelectedPet {

    public static Question<Boolean> hasName(String name){
        return a -> lastResponse().getBody().as(Pet.class).getName().equals(name);
    }

    public static Question<Boolean> hasPetId(Long petId){
        return a -> lastResponse().getBody().as(Pet.class).getId().equals(petId);
    }

    public static Question<Boolean> hasPhotoUrls(List<String> photoUrls){
        return a -> lastResponse().getBody().as(Pet.class).getPhotoUrls().containsAll(photoUrls);
    }

    public static Question<Boolean> hasStatus(String status){

        return a -> lastResponse().getBody().as(Pet.class).getStatus().equals(status);
    }
}
