package util;

public enum Type {

    H("H"),
    V("V");

    private String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
