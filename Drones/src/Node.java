public class Node {
    private int row;
    private int col;
    private int g;
    private int h;
    private int f;
    private Node parent;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.g = 0;
        this.h = 0;
        this.f = 0;
        this.parent = null;
    }
// getters and setters.
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getNeighbors(Node[][] grid, int rows, int cols) {
        List<Node> neighbors = new ArrayList<>();

        int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dc = {0, -1, 0, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                Node neighbor = grid[newRow][newCol];
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public void setObstacle(boolean isObstacle) {

    }
}
