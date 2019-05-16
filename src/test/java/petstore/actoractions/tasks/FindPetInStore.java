package petstore.actoractions.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static petstore.endpoints.PetStore.GET_PET_BY_ID;

public class FindPetInStore implements Task {

    private final Long id;

    public FindPetInStore(Long id) {
        this.id = id;
    }

    public static FindPetInStore byId(Long id){
        return instrumented(FindPetInStore.class, id);
    }

    @Override
    @Step("{0} tries to find pet with id: #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(GET_PET_BY_ID.path())
                .with(requestSpecification -> requestSpecification
                        .pathParam("petId", id)
                        .contentType(ContentType.JSON)));
    }
}
