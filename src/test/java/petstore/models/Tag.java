
package petstore.models;

import petstore.models.builder.TagBuilder;

public class Tag {

    private Long id;

    private String name;

    public Tag(TagBuilder builder){
        id = builder.getId();
        name = builder.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
