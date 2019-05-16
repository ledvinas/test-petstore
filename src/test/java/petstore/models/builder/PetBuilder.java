
package petstore.models.builder;

import petstore.models.Category;
import petstore.models.Pet;
import petstore.models.Tag;

import java.util.List;

public class PetBuilder implements Builder<Pet> {

    private Long id;

    private String name;

    private List<String> photoUrls;

    private String status;

    private List<Tag> tags;

    private Category category;

    private PetBuilder(Long id) {
        this.id = id;
    }

    public static PetBuilder withId(Long id){
        return new PetBuilder(id);
    }

    public Pet andStatus(String status) {
        this.status = status;
        return build();
    }

    public PetBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder withPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetBuilder withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public PetBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public Pet build() {
        return new Pet(this);
    }
}
