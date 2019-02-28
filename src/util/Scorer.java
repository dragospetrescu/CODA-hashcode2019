package util;

import pics.Pic;

import java.util.List;

public class Scorer {

    public static int getScore(Pic pic1, Pic pic2) {
        int common = 0;
        int uncommon1 = 0;
        int uncommon2 = 0;

        int[] tags1 = pic1.getTags();
        int[] tags2 = pic2.getTags();

        for (Integer tag1: tags1) {
            for (Integer tag2: tags2) {
                if(tag2 > tag1) {
                    break;
                }
                if(tag2 == tag1) {
                    common++;
                    break;
                }
            }

        }
    }

}
