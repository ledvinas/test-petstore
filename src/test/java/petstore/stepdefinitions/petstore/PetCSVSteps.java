package petstore.stepdefinitions.petstore;

import petstore.models.Category;
import petstore.models.Tag;
import petstore.models.builder.CategoryBuilder;
import petstore.models.builder.TagBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static petstore.Utils.splitStringToList;

public class PetCSVSteps {

    private int petId;
    private String petName;
    private String status;
    private String photoUrls;
    private int categoryId;
    private String categoryName;
    private String tagIds;
    private String tagNames;

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setTagId(String tagIds) {
        this.tagIds = tagIds;
    }

    public void setTagName(String tagNames) {
        this.tagNames = tagNames;
    }

    public String getPetName() {
        return petName;
    }

    public long getPetId() {
        return petId;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getPhotoUrls() {
        return Arrays.asList(photoUrls.split("-"));
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTagId() {
        return tagIds;
    }

    public String getTagName() {
        return tagNames;
    }

    public List<Tag> getTags() {
        List<Tag> tagList = new ArrayList<>();

        IntStream.range(0,  splitStringToList(tagIds).size()).forEach(i -> {
            tagList.add(TagBuilder.withId(Long.parseLong(splitStringToList(tagIds).get(i)))
                    .andName(splitStringToList(tagNames).get(i)));
        });
        return tagList;
    }

    public Category getCategory() {
        return CategoryBuilder
                .withId((long)categoryId)
                .andName(categoryName);
    }
}
