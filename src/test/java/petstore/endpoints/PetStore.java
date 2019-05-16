package petstore.endpoints;

public enum PetStore {

    POST_ADD_PET("/v2/pet"),
    GET_PET_BY_ID("/v2/pet/{petId}");

    private final String path;

    PetStore(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
