package pics;

public class Edge {
    private Slide source;
    private Slide dest;
    private int score;

    public Edge(){}

    public Edge(Slide source, Slide dest, int score) {
        this.source = source;
        this.dest = dest;
        this.score = score;
    }

    public Slide getSource() {
        return source;
    }

    public void setSource(Slide source) {
        this.source = source;
    }

    public Slide getDest() {
        return dest;
    }

    public void setDest(Slide dest) {
        this.dest = dest;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
