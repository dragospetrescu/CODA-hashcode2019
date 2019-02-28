package util;

import pics.Pic;

public class Scorer {

    public static int getScore(Pic pic1, Pic pic2) {
        int common = 0;
        int uniq1 = 0;
        int uniq2 = 0;

        int[] tags1 = pic1.getTags();
        int[] tags2 = pic2.getTags();

        // TODO: MAKE THE SMALLER LIST SECOND
        for (int tag1: tags1) {
            for (int tag2: tags2) {
                if(tag2 == tag1) {
                    common++;
                    break;
                }
                if(tag2 > tag1) {
                    uniq1++;
                    break;
                }
            }

        }

        int numTotalEls = tags1.length + tags2.length;
        uniq2 = numTotalEls - common * 2 - uniq1;

        int min_temp = Math.min(common, uniq1);
        return Math.min(min_temp, uniq2);
    }

}
