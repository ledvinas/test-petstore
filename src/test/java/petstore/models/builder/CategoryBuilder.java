
package petstore.models.builder;

import petstore.models.Category;

public class CategoryBuilder implements Builder<Category> {

    private Long id;

    private String name;

    private CategoryBuilder(Long id) {
        this.id = id;
    }

    public static CategoryBuilder withId(Long id){
        return new CategoryBuilder(id);
    }

    public Category andName(String name) {
        this.name = name;
        return build();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Category build() {
        return new Category(this);

    }
}
