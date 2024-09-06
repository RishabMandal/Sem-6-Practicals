import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class bestfirstsearch {
    public static void input(Map<Integer, List<Integer>> graph) {
        graph.put(1, new ArrayList<Integer>(Arrays.asList(2, 3)));
        graph.put(2, new ArrayList<Integer>(Arrays.asList(4, 5)));
        graph.put(3, new ArrayList<Integer>(Arrays.asList(5, 6)));
        graph.put(4, new ArrayList<Integer>());
        graph.put(5, new ArrayList<Integer>(Arrays.asList(7, 8)));
        graph.put(6, new ArrayList<Integer>());
        graph.put(7, new ArrayList<Integer>());
        graph.put(8, new ArrayList<Integer>());
    }

    // Important compare function for priority queue
    // class CustomPriority extends Comparator<Integer> {
    // public int compare(Integer o1, Integer o2) {
    // if (heuristic.get(o1) < heuristic.get(o2))
    // return 1;
    // else if (heuristic.get(o2) > heuristic.get(o1))
    // return -1;
    // return 0;
    // }
    // }

    static Map<Integer, Integer> heuristic = new HashMap<>();

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Set<Integer> visited = new HashSet<Integer>();
        input(graph);
        heuristicInput();
        int search = 7;
        // Important compare function for priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (heuristic.get(o1) > heuristic.get(o2))
                    return 1;
                else if (heuristic.get(o1) < heuristic.get(o2))
                    return -1;
                return 0;
            }
        });
        queue.add(1);
        while (!queue.isEmpty()) {
            int root = queue.poll();
            System.out.print(root + " -> ");
            while (!queue.isEmpty())
                queue.poll();
            for (Integer node : graph.get(root)) {
                queue.add(node);
                if (node == search)
                    break;
            }
        }
    }

    public static void heuristicInput() {
        heuristic.put(1, 1);
        heuristic.put(2, 10);
        heuristic.put(3, 9);
        heuristic.put(4, Integer.MAX_VALUE);
        heuristic.put(5, 1);
        heuristic.put(6, Integer.MAX_VALUE);
        heuristic.put(7, 0);
        heuristic.put(8, Integer.MAX_VALUE);
    }
}

// 1
// / \
// 2 3
// /\/\
// 4 5 6
// - /\
// - 7 8
