import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a grid with a size of 20x20 units
        Grid grid = new Grid(20, 20);

        // Define the list of drones
        List<Drone> drones = new ArrayList<>();

        // Define the start and end nodes for each drone
        Node start1 = grid.getNode(1, 1);
        Node end1 = grid.getNode(5, 5);
        Drone drone1 = new Drone(start1.getRow(), start1.getCol(),end1.getRow(),end1.getCol(),0);
        drones.add(drone1);

        Node start2 = grid.getNode(10, 10);
        Node end2 = grid.getNode(15, 15);
        Drone drone2 = new Drone(start2.getRow(),start2.getCol(), end2.getRow(), end2.getCol(), 2);
        drones.add(drone2);

        // Add the drones to the grid
        grid.addDrones(drones);

        // Run A* algorithm for each drone to find their path
        for (Drone drone : drones) {
            List<Node> path = AStar.findPath(grid, drone.getStartNode(), drone.getEndNode());
            drone.setPath(path);
        }

        // Print the path for each drone
        for (Drone drone : drones) {
            System.out.println("Drone " + drone.getId() + " path:");
            for (Node node : drone.getPath()) {
                System.out.println(node.getX() + "," + node.getY());
            }
        }
    }
}
