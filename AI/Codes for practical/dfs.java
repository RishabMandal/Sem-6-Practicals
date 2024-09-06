import java.util.*;

class dfs {
    public static void dfsTraversal(Map<Integer, List<Integer>> graph, Integer root, List<Integer> visited,
            int maxLevel, int currentLevel) {
        if (currentLevel > maxLevel)
            return;
        visited.add(root);
        for (int node : graph.get(root)) {
            dfsTraversal(graph, node, visited, maxLevel, currentLevel + 1);
            System.out.println("Visited list: " + visited);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        graph.put(0, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        graph.put(1, new ArrayList<Integer>());
        graph.put(2, new ArrayList<Integer>(Arrays.asList(4, 5)));
        graph.put(3, new ArrayList<Integer>());
        graph.put(4, new ArrayList<Integer>());
        graph.put(5, new ArrayList<Integer>());
        List<Integer> visited = new ArrayList<Integer>();
        dfsTraversal(graph, 0, visited, 3, 1);
    }
}