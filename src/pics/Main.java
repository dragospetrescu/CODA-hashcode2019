package pics;

import util.MyScanner;
import util.Type;
import util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {


    public static void main(String[] args) {

        int outIdx = 0;

        for (String file : Util.INPUT_FILES) {
            System.out.println("Computing " + file);

            Pictures pictures = read(Util.INPUT_FOLDER + file);
            computeAlgo(pictures);
            writeResults(Util.OUTPUT_FOLDER + Util.OUTPUT_FILES[outIdx++]);
        }

        System.out.println("Results are ready!");


    }


    /**
     * Compute some algorithm to solve the problem.
     *
     *
     */
    private static void computeAlgo(Pictures pictures) {
        List<Pic> horizontals = pictures.horizontal;
        List<Pic> verticals = pictures.vertical;

        int[][] multi = new int[5][10];

    }



    /**
     * Read input data from file.
     *
     *
     * @param filename file to read from
     */
    private static Pictures read(String filename) {
        MyScanner scanner = new MyScanner(new File(filename));
        TagStringToId converter = new TagStringToId();

        List<Pic> pictures = new ArrayList<>();

        Util.PHOTOS_NO = scanner.nextInt();

        for (int i = 0; i < Util.PHOTOS_NO; i++) {
            String type = scanner.next();
            int tagsNo = scanner.nextInt();
            int[] tags = new int[tagsNo];

            for (int j = 0; j < tagsNo; j++) {
                tags[j] = converter.getIdOfTag(scanner.next());
            }

            Arrays.sort(tags);
            Pic pic = new Pic(Type.valueOf(type), tags);
            pictures.add(pic);
        }

        return new Pictures();
    }


    /**
     * Write results to file.
     *
     *
     * @param outFile file to write to
     */
    private static void writeResults(String outFile) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(new File(outFile));
            bw = new BufferedWriter(fw);

            StringBuilder content = new StringBuilder();

            // compute content

            bw.write(content.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
