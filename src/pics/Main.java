package pics;

import util.MyScanner;
import util.Scorer;
import util.Type;
import util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


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
        List<Slide> slides = new ArrayList<>();

        List<Pic> horizontals = pictures.horizontal;
        for (Pic horizontal: horizontals) {
            Slide slide = new Slide(horizontal.getType(), horizontal.getTags(), horizontal);
            slides.add(slide);
        }

        List<Pic> verticals = pictures.vertical;

        createVerticalPics(verticals, slides);

        for (Slide slide: slides) {
            System.out.println(slide.);

        }


    }

    private static void createVerticalPics(List<Pic> verticals, List<Slide> slides) {

        for (int i = 0; i < verticals.size(); i++) {
            Pic vertical1 = verticals.get(i);
            for (int j = 0; j < i + 1; j++) {
                Pic vertical2 = verticals.get(j);
                int[] tags = Util.combineTags(vertical1.getTags(), vertical2.getTags());
                Slide slide = new Slide(Type.V, tags, vertical1, vertical2);
                slides.add(slide);

            }
        }

    }

    private static List<Edge> edgeScoring(List<Slide> slides){
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < slides.size() - 1; i++){
            for(int j = i + 1; j < slides.size();j++){
                edges.add(new Edge(slides.get(i), slides.get(j), Scorer.getScore(slides.get(i), slides.get(j))));
            }
        }
        return edges;
    }

    private static ArrayList<Edge> kruskal(List<Edge> allEdges, List<Pic> vertices) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(Edge::getScore).reversed());

        pq.addAll(allEdges);

        //create a parent []
        int[] parent = new int[vertices.size()];

        //makeset
        makeSet(parent, vertices.size());

        ArrayList<Edge> mst = new ArrayList<>();

        //process vertices - 1 edges
        int index = 0;

        while (index < vertices.size() - 1) {
            Edge edge = pq.remove();

            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.getSource().id);
            int y_set = find(parent, edge.getDest().id);

            if (x_set == y_set) {
                //ignore, will create cycle
            } else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }

        return mst;
    }

    public static void makeSet(int[] parent, int size){
        //Make set - creating a new element with a parent pointer to itself.
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public static int find(int[] parent, int vertex){
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if(parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    public static void union(int[] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
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

        Pictures pictures = new Pictures();

        Util.PHOTOS_NO = scanner.nextInt();

        for (int i = 0; i < Util.PHOTOS_NO; i++) {
            String type = scanner.next();
            int tagsNo = scanner.nextInt();
            int[] tags = new int[tagsNo];

            for (int j = 0; j < tagsNo; j++) {
                tags[j] = converter.getIdOfTag(scanner.next());
            }

            Arrays.sort(tags);
            Pic pic = new Pic(Type.valueOf(type), tags, i);

            if (Type.H.equals(pic.getType())) {
                pictures.horizontal.add(pic);
            } else {
                pictures.vertical.add(pic);
            }
        }

        return pictures;
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
