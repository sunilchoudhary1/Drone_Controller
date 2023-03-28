import java.util.*;

public class AStar {
    public static List<Node> findPath(Grid grid, Node start, Node end) {
        List<Node> openSet = new ArrayList<>();
        Set<Node> closedSet = new HashSet<>();

        start.setG(0);
        start.setH(getHeuristicCost(start, end));
        start.setF(start.getG() + start.getH());
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node currentNode = getLowestFScoreNode(openSet);
            if (currentNode.equals(end)) {
                return constructPath(currentNode);
            }

            openSet.remove(currentNode);
            closedSet.add(currentNode);

            List<Node> neighbors = grid.getNeighbors(currentNode);
            for (Node neighbor : neighbors) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeGScore = currentNode.getG() + getDistanceBetween(currentNode, neighbor);

                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tentativeGScore >= neighbor.getG()) {
                    continue;
                }

                neighbor.setParent(currentNode);
                neighbor.setG(tentativeGScore);
                neighbor.setH(getHeuristicCost(neighbor, end));
                neighbor.setF(neighbor.getG() + neighbor.getH());
            }
        }

        return new ArrayList<>();
    }

    private static int getDistanceBetween(Node node1, Node node2) {
        int xDiff = Math.abs(node1.getX() - node2.getX());
        int yDiff = Math.abs(node1.getY() - node2.getY());

        if (xDiff > yDiff) {
            return 14 * yDiff + 10 * (xDiff - yDiff);
        } else {
            return 14 * xDiff + 10 * (yDiff - xDiff);
        }
    }

    private static int getHeuristicCost(Node node, Node endNode) {
        int xDiff = Math.abs(node.getX() - endNode.getX());
        int yDiff = Math.abs(node.getY() - endNode.getY());
        return 10 * (xDiff + yDiff);
    }

    private static Node getLowestFScoreNode(List<Node> nodes) {
        Node lowestNode = nodes.get(0);
        for (Node node : nodes) {
            if (node.getF() < lowestNode.getF()) {
                lowestNode = node;
            }
        }
        return lowestNode;
    }

    private static List<Node> constructPath(Node node) {
        List<Node> path = new ArrayList<>();
        path.add(node);
        while (node.getParent() != null) {
            node = node.getParent();
            path.add(0, node);
        }
        return path;
    }
}
