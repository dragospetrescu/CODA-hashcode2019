package pics;

import util.Type;
import util.Util;

import java.util.Arrays;

public class Slide {

    int id;
    Type type;
    int[] tags;
    Pic pic1;
    Pic pic2;

    public int[] getTags() {
        return tags;
    }

    public Slide(Type type, int[] tags, Pic pic1, Pic pic2) {
        this.type = type;
        this.tags = tags;
        this.pic1 = pic1;
        this.pic2 = pic2;
        id = Util.crtSlideId++;
    }

    public Slide(Type type, int[] tags, Pic pic1) {
        this.type = type;
        this.tags = tags;
        this.pic1 = pic1;
        id = Util.crtSlideId++;
    }

    @Override
    public String toString() {
        if(type == Type.V)
            return pic1.getId() + " " + pic2.getId();
        return "" + pic1.getId();
    }
}
