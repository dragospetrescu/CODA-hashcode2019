package pics;

import util.Type;

import java.util.List;

public class Pic {

    private Type type;
    private int[] tags;
    private int id;

    public Pic() {}

    public Pic(Type type, int[] tags, int id) {
        this.type = type;
        this.tags = tags;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public int[] getTags() {
        return tags;
    }

    public int getNoTags() {
        return tags.length;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
