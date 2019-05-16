
package petstore.models;

import petstore.models.builder.CategoryBuilder;

public class Category {

    public Category(CategoryBuilder builder) {
        id = builder.getId();
        name = builder.getName();
    }

    private Long id;

    private String name;

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
