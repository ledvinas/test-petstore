package petstore.actoractions.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import petstore.models.Pet;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static petstore.endpoints.PetStore.POST_ADD_PET;

public class AddPetToStore implements Performable {

    private final Pet pet;

    public AddPetToStore(Pet pet) {
        this.pet = pet;
    }

    public static AddPetToStore addPetToStore(Pet pet){
        return instrumented(AddPetToStore.class, pet);
    }

    @Override
    @Step("{0} adds pet to pet store")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(POST_ADD_PET.path())
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(pet)));
    }
}
