import java.util.*;

public class aStart2 {
    public static class Node {
        String node;
        int cost;

        Node(String node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Node>> graph = new HashMap<String, List<Node>>();
        Map<String, Integer> heuristicVal = new HashMap<>();
        Set<String> visited = new HashSet<>();
        input(graph);
        heuristicInput(heuristicVal);
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                int val1 = o1.cost + heuristicVal.get(o1.node);
                int val2 = o2.cost + heuristicVal.get(o2.node);
                if (val1 < val2)
                    return -1;
                else if (val1 > val2)
                    return 1;
                return 0;
            }
        });
        boolean found = false;
        queue.add(new Node("A", 0));
        while (!queue.isEmpty() && !found) {
            print(queue);
            Node root = queue.poll();
            String nodeVal = root.node;
            // System.out.println(queue);
            // System.out.print(nodeVal + " -> ");
            for (Node nodes : graph.get(nodeVal)) {
                if (visited.contains(nodes.node))
                    continue;
                if (nodes.node == "G") {
                    print(queue);
                    System.out.println("G found");
                    found = true;
                    break;
                }
                int finalCost = nodes.cost + root.cost;
                queue.add(new Node(nodes.node, finalCost));
                visited.add(nodes.node);
            }
        }
    }

    public static void input(Map<String, List<Node>> graph) {
        graph.put("A", new ArrayList<Node>(Arrays.asList(new Node("B", 6), new Node("C", 12))));
        graph.put("B", new ArrayList<Node>(Arrays.asList(new Node("D", 2), new Node("E", 53))));
        graph.put("C", new ArrayList<Node>(Arrays.asList(new Node("E", 4), new Node("F", 10))));
        graph.put("D", new ArrayList<Node>());
        graph.put("E", new ArrayList<Node>(Arrays.asList(new Node("G", 4), new Node("H", 3))));
        graph.put("F", new ArrayList<Node>());
        graph.put("G", new ArrayList<Node>());
        graph.put("H", new ArrayList<Node>());
    }

    public static void heuristicInput(Map<String, Integer> heuristicVal) {
        heuristicVal.put("A", 20);
        heuristicVal.put("B", 12);
        heuristicVal.put("C", 8);
        heuristicVal.put("D", Integer.MAX_VALUE - 199);
        heuristicVal.put("E", 4);
        heuristicVal.put("F", Integer.MAX_VALUE - 199);
        heuristicVal.put("G", 0);
        heuristicVal.put("H", Integer.MAX_VALUE - 199);
    }

    public static void print(PriorityQueue<Node> queue) {
        PriorityQueue<Node> originalQueue = new PriorityQueue<>(queue); // Create a copy of the original queue

        // Print elements of the PriorityQueue
        for (Node node : originalQueue) {
            System.out.print("Node: " + node.node + ", Cost: " + node.cost + "; ");
        }
        System.out.println();
    }
}
