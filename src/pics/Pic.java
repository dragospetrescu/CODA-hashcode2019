package pics;

import util.Type;

import java.util.List;

public class Pic {

    private Type type;
    private List<Integer> tags;

    public Pic() {}

    public Pic(Type type, List<Integer> tags) {
        this.type = type;
        this.tags = tags;
    }

    public Type getType() {
        return type;
    }

    public int[] getTags() {
        return tags;
    }

    public int getNoTags() {
        return tags.size();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
}
