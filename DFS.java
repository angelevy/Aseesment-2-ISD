import java.util.*;

public class DFS {

    private static Map<String, List<String>> graf = new HashMap<>();

    private static void dfs(String node, Set<String> visited) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);

            List<String> neighbors = graf.get(node);
            for (String neighbor : neighbors) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graf();

        System.out.println("DFS Output:");
        Set<String> visited = new HashSet<>();
        dfs("Paris", visited);
    }

    private static void Graf() {
        graf.put("Paris", Arrays.asList("Brussels", "Zurich"));
        graf.put("Zurich", Arrays.asList("Paris", "Brussels", "Prague", "Vienna"));
        graf.put("Brussels", Arrays.asList("Paris", "Zurich", "Amsterdam"));
        graf.put("Amsterdam", Arrays.asList("Brussels", "Prague", "Hamburg"));
        graf.put("Hamburg", Arrays.asList("Amsterdam", "Prague", "Warsaw"));
        graf.put("Warsaw", Arrays.asList("Hamburg", "Prague", "Budapest"));
        graf.put("Budapest", Arrays.asList("Vienna", "Warsaw"));
        graf.put("Prague", Arrays.asList("Zurich", "Amsterdam", "Hamburg", "Warsaw", "Budapest"));
        graf.put("Vienna", Arrays.asList("Prague", "Zurich", "Budapest"));
    }
}