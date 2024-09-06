import java.util.*;

// Class to represent a node in the graph
class Node {
    int id;
    List<Edge> neighbors; // List of neighboring nodes

    public Node(int id) {
        this.id = id;
        neighbors = new ArrayList<>();
    }
}

// Class to represent an edge between nodes in the graph
class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class UCS {
    // Uniform Cost Search algorithm
    public static List<Node> ucs(Node start, Node goal) {
        Map<Node, Integer> cost = new HashMap<>(); // Cost from start to a node
        Map<Node, Node> cameFrom = new HashMap<>(); // For reconstructing the path

        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(cost::get));
        Set<Node> closedSet = new HashSet<>();

        cost.put(start, 0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current == goal) {
                return reconstructPath(cameFrom, current);
            }

            closedSet.add(current);

            for (Edge neighborEdge : current.neighbors) {
                Node neighbor = neighborEdge.target;
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int newCost = cost.get(current) + neighborEdge.weight;
                if (!cost.containsKey(neighbor) || newCost < cost.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    cost.put(neighbor, newCost);
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null; // No path found
    }

    // Method to reconstruct the path from start to goal
    private static List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
        List<Node> path = new ArrayList<>();
        while (cameFrom.containsKey(current)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    // Example usage
    public static void main(String[] args) {
        // Create graph nodes
        Node start = new Node(0); // Start node
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3); // Goal node

        // Create edges between nodes
        start.neighbors.add(new Edge(a, 3));
        start.neighbors.add(new Edge(b, 2));
        a.neighbors.add(new Edge(c, 1));
        b.neighbors.add(new Edge(c, 2));

        // Perform UCS
        List<Node> path = ucs(start, c);

        // Print the path
        if (path != null) {
            for (Node node : path) {
                System.out.print(node.id + " ");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
