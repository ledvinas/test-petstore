package petstore.actoractions.questions;

import net.serenitybdd.screenplay.Question;
import org.junit.Assert;
import petstore.models.Pet;
import petstore.models.Tag;

import java.util.List;
import java.util.stream.IntStream;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class SelectedPetsTags {

    public static Question<Boolean> haveTags(List<Tag> tags){
        return a -> {
            IntStream.range(0, tags.size()).forEach(i -> {
                List<Tag> responseTags = lastResponse().getBody().as(Pet.class).getTags();
                Assert.assertEquals(responseTags.get(i).getId(), tags.get(i).getId());
                Assert.assertEquals(responseTags.get(i).getName(), tags.get(i).getName());
            });
            return true;
        };
    }
}
