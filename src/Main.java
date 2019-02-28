import util.MyScanner;
import util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {

        int outIdx = 0;

        for (String file : Util.INPUT_FILES) {
            System.out.println("Computing " + file);

            read(Util.INPUT_FOLDER + file);
            computeAlgo();
            writeResults(Util.OUTPUT_FOLDER + Util.OUTPUT_FILES[outIdx++]);
        }

        System.out.println("Results are ready!");


    }


    /**
     * Compute some algorithm to solve the problem.
     *
     *
     */
    private static void computeAlgo() {

    }



    /**
     * Read input data from file.
     *
     *
     * @param filename file to read from
     */
    private static void read(String filename) {
        MyScanner scanner = new MyScanner(new File(filename));

        Util.WIDTH = scanner.nextInt();
        Util.HEIGHT = scanner.nextInt();
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
