
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment02Task02 {

    static int[][] graph;
    static boolean[] visited;
    static int[] distances;
    static int[] parents;
    static ArrayList<Integer> paths = new ArrayList<>();

    static int min_Distance() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false && distances[i] <= min) {
                min = distances[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int src) {
        parents[src] = -1;
        distances[src] = 0;
        for (int i = 0; i < graph.length; i++) {
            int u = min_Distance(); // gets the vertex with min distance and starts to relax its child
            if (u != -1) {
                visited[u] = true; // marks the parent vertex as visited
            }
            for (int j = 0; j < graph.length; j++) {
                if (!visited[j] && graph[u][j] != 0 && distances[u] + graph[u][j] < distances[j]) {
                    parents[j] = u;
                    distances[j] = distances[u] + graph[u][j];
                }
            }
        }
    }

    static void fillPath(int d) {
        while (d != -1) {
            paths.add(d);
            d = parents[d];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        graph = new int[vertices][vertices];
        distances = new int[graph.length];
        parents = new int[graph.length];
        visited = new boolean[graph.length];
        String[] places = {"Mouchak", "Panthapath", "Rampura", "Shahahbagh", "Dhanmondi", "Lalmatia", "Badda", "Hatirjheel", "Nilkhet", "TSC", "Dhaka University", "BUET"};

        // inputs
        for (int i = 0; i < graph.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        for (int i = 0; i < edges; i++) {
            String[] inputs = sc.nextLine().split(",");
            int x, y, w;
            x = Integer.parseInt(inputs[0]);
            y = Integer.parseInt(inputs[1]);
            w = Integer.parseInt(inputs[2]);
            graph[x][y] = w;
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        sc.nextLine();
        String[] avoid = sc.nextLine().split(",");
        for (String s : avoid) {
            visited[Integer.parseInt(s)] = true;
        }

        dijkstra(source);
        fillPath(dest);
        for (int i = paths.size() - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(places[paths.get(i)]);
            } else {
                System.out.print(places[paths.get(i)] + "->");
            }
        }
        System.out.println("Path Cost: " + distances[dest]);
    }
}
