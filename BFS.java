import java.util.*;

public class BFS {
    private Map<String, List<String>> list;

    public BFS() {
        this.list = new HashMap<>();
        Graf();
    }

    private void Graf() {
        list.put("Paris", Arrays.asList("Brussels", "Zurich"));
        list.put("Zurich", Arrays.asList("Paris", "Brussels", "Prague", "Vienna"));
        list.put("Brussels", Arrays.asList("Paris", "Zurich", "Amsterdam"));
        list.put("Amsterdam", Arrays.asList("Brussels", "Prague", "Hamburg"));
        list.put("Hamburg", Arrays.asList("Amsterdam", "Prague", "Warsaw"));
        list.put("Warsaw", Arrays.asList("Hamburg", "Prague", "Budapest"));
        list.put("Budapest", Arrays.asList("Vienna", "Warsaw"));
        list.put("Prague", Arrays.asList("Zurich", "Amsterdam", "Hamburg", "Warsaw", "Budapest"));
        list.put("Vienna", Arrays.asList("Prague", "Zurich", "Budapest"));
    }

    public void bfs(String bfs) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(bfs);
        visited.add(bfs);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            List<String> neighbors = list.get(vertex);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS();

        System.out.println("BFS Output:");
        graph.bfs("Paris");
    }
}