import java.util.List;

public class Drone {
    private int id;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int startTime;
    private List<Node> path;

    public Drone(int startX, int startY, int endX, int endY, int startTime) {

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartTime() {
        return startTime;
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public Node getStartNode() {
        return new Node(startX, startY);
    }

    public Node getEndNode() {
        return new Node(endX, endY);
    }

    @Override
    public String toString() {
        return "Drone " + id;
    }
}
