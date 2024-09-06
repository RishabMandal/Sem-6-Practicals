import java.util.*;

public class aStar {
    static Map<String, Integer> nodeValues = new HashMap<String, Integer>();
    static Map<String, Integer> heuristic = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        input(graph);
        inpHeuristic();
        inpNodeVal();
        int pathCost = 0;
        // Remember the syntax
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                int val1 = nodeValues.get(o1) + heuristic.get(o1);
                int val2 = nodeValues.get(o2) + heuristic.get(o2);
                if (val1 < val2)
                    return -1;
                else if (val1 > val2)
                    return 1;
                return 0;
            }
        });
        queue.add("A");
        while (!queue.isEmpty()) {
            String root = queue.poll();
            System.out.print(root + " -> ");
            pathCost += nodeValues.get(root);
            while (!queue.isEmpty())
                queue.poll();
            for (String nodes : graph.get(root)) {
                queue.add(nodes);
            }
        }
        System.out.println("\nPath cost: " + pathCost);
    }

    public static void input(Map<String, List<String>> graph) {
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("D", "E")));
        graph.put("C", new ArrayList<String>(Arrays.asList("E", "F")));
        graph.put("D", new ArrayList<String>());
        graph.put("E", new ArrayList<String>(Arrays.asList("G", "H")));
        graph.put("F", new ArrayList<String>());
        graph.put("G", new ArrayList<String>());
        graph.put("H", new ArrayList<String>());
    }

    // Important Integer.maxvalue - 99 as it would pass above int maxvalue when add
    // with heuristic
    public static void inpHeuristic() {
        heuristic.put("A", 1);
        heuristic.put("B", 10);
        heuristic.put("C", 9);
        heuristic.put("D", Integer.MAX_VALUE - 99);
        heuristic.put("E", 1);
        heuristic.put("F", Integer.MAX_VALUE - 99);
        heuristic.put("G", 0);
        heuristic.put("H", Integer.MAX_VALUE - 99);
    }

    public static void inpNodeVal() {
        nodeValues.put("A", 1);
        nodeValues.put("B", 10);
        nodeValues.put("C", 29);
        nodeValues.put("D", 91);
        nodeValues.put("E", 10);
        nodeValues.put("F", 1);
        nodeValues.put("G", 0);
        nodeValues.put("H", 1);
    }
}

// A
// / \
// B C
// /\/\
// D E F
// - /\
// - G H
