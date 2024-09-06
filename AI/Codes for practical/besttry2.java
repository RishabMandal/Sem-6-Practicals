import java.util.*;

public class besttry2 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> heuristicVal = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (heuristicVal.get(o1) < heuristicVal.get(o2))
                    return -1;
                else if (heuristicVal.get(o1) > heuristicVal.get(o2))
                    return 1;
                return 0;
            }
        });
        int search = 7;
        boolean found = false;
        input(graph);
        heuristicInput(heuristicVal);
        queue.add(1);
        System.out.print("Final Path: ");
        while (!queue.isEmpty() && !found) {
            int root = queue.poll();
            System.out.print(root + " -> ");
            for (int node : graph.get(root)) {
                if (visited.contains(node))
                    continue;
                if (node == search) {
                    found = true;
                    break;
                }
                queue.add(node);
                visited.add(node);
            }
        }
        System.out.println(search);
    }

    public static void input(Map<Integer, List<Integer>> graph) {
        graph.put(1, new ArrayList<>(Arrays.asList(2, 3)));
        graph.put(2, new ArrayList<Integer>(Arrays.asList(4, 5)));
        graph.put(3, new ArrayList<Integer>(Arrays.asList(5, 6)));
        graph.put(4, new ArrayList<Integer>());
        graph.put(5, new ArrayList<Integer>(Arrays.asList(7, 8)));
        graph.put(6, new ArrayList<Integer>());
        graph.put(7, new ArrayList<Integer>());
        graph.put(8, new ArrayList<Integer>());
    }

    public static void heuristicInput(Map<Integer, Integer> heuristicVal) {
        heuristicVal.put(1, 20);
        heuristicVal.put(2, 12);
        heuristicVal.put(3, 8);
        heuristicVal.put(4, Integer.MAX_VALUE - 99);
        heuristicVal.put(5, 4);
        heuristicVal.put(6, Integer.MAX_VALUE - 99);
        heuristicVal.put(7, 0);
        heuristicVal.put(8, Integer.MAX_VALUE - 99);
    }
}

// 1
// / \
// 2 3
// /\/\
// 4 5 6
// - /\
// - 7 8