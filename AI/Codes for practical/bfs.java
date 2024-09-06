import java.util.*;

public class bfs {
    public static void input(Map<Integer, List<Integer>> graph) {
        graph.put(1, new ArrayList<Integer>(Arrays.asList(2, 3)));
        graph.put(2, new ArrayList<Integer>(Arrays.asList(4, 5)));
        graph.put(3, new ArrayList<Integer>(Arrays.asList(5, 6)));
        graph.put(4, new ArrayList<Integer>(Arrays.asList(7, 8)));
        graph.put(5, new ArrayList<Integer>());
        graph.put(6, new ArrayList<Integer>());
        graph.put(7, new ArrayList<Integer>());
        graph.put(8, new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Set<Integer> visited = new HashSet<Integer>();
        input(graph);
        int search = 7;
        boolean flag = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visited.add(1);
        System.out.println("Open list: " + queue);
        while (!queue.isEmpty() && flag) {
            int size = queue.size();
            System.out.print("Closed list: " + visited + "\t");
            while (size-- > 0 && flag) {
                int curr = queue.poll();
                for (int node : graph.get(curr)) {
                    if (visited.contains(node))
                        continue;
                    queue.add(node);
                    visited.add(node);
                    if (node == search) {
                        System.out.println("Open list: " + queue);
                        System.out.println("Node found");
                        flag = false;
                        break;
                    }
                }
            }
            System.out.println("Open list: " + queue);
        }
    }
}

// 1
// / \
// 2 3
// /\/\
// 4 5 6
// /\
// 7 8
