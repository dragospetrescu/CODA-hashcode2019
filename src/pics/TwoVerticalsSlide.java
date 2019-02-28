package pics;

import util.Type;

public class TwoVerticalsSlide {

    private int[] tags;

    public Pic() {}

    public Pic(int[] tags) {
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
        return tags.length;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }
}
