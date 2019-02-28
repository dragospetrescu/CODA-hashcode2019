package pics;

import util.Type;

public class Slide {

    Type type;
    int[] tags;
    Pic pic1;
    Pic pic2;

    public Slide(Type type, int[] tags, Pic pic1, Pic pic2) {
        this.type = type;
        this.tags = tags;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    public Slide(Type type, int[] tags, Pic pic1) {
        this.type = type;
        this.tags = tags;
        this.pic1 = pic1;
    }
}
