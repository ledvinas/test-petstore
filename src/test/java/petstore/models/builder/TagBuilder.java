
package petstore.models.builder;

import petstore.models.Tag;

public class TagBuilder implements Builder<Tag> {

    private Long id;

    private String name;

    private TagBuilder(Long id) {
        this.id = id;
    }

    public static TagBuilder withId(Long id){
        return new TagBuilder(id);
    }

    public Tag andName(String name) {
        this.name = name;
        return build();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tag build() {
        return new Tag(this);
    }
}
