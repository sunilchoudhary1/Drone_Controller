import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int rows;
    private final int cols;
    private final Node[][] nodes;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.nodes = new Node[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Node getNode(int row, int col) {
        return nodes[row][col];
    }

    public List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        int row = node.getRow();
        int col = node.getCol();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int neighborRow = row + i;
                int neighborCol = col + j;

                if (neighborRow < 0 || neighborRow >= rows || neighborCol < 0 || neighborCol >= cols) {
                    continue;
                }

                Node neighborNode = nodes[neighborRow][neighborCol];

                if (!neighborNode.isObstacle()) {
                    neighbors.add(neighborNode);
                }
            }
        }

        return neighbors;
    }

    public void setObstacle(int row, int col, boolean isObstacle) {
        nodes[row][col].setObstacle(isObstacle);
    }

    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j].reset();
            }
        }
    }
}
