package util;

import java.util.Set;
import java.util.TreeSet;

public class Util {

    public static int PHOTOS_NO;

    public static final String INPUT_FOLDER = "input/";
    public static int crtSlideId = 0;

    public static final String OUTPUT_FOLDER = "output/";

    public static final String[] OUTPUT_FILES = {
//            "a.out",
            "b.out",
            "c.out",
            "d.out",
            "e.out"
    };

    public static final String[] INPUT_FILES = {
//            "a_example.txt",
            "b_lovely_landscapes.txt"
    };


    public static int[] combineTags(int[] tags1, int[] tags2) {
        Set<Integer> set = new TreeSet<>();


        for (int tag : tags1) {
            set.add(tag);
        }
        for (int tag : tags2) {
            set.add(tag);
        }
        int[] array = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            array[i] = val;
            i++;
        }

        return array;
    }


}
