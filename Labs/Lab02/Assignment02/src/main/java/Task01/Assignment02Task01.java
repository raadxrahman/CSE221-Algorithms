//import java.util.Arrays;

import java.util.Scanner;

public class Assignment02Task01 {

    static int[][] graph;
    static boolean[] visited;
    static int[] distances;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        int midDest = sc.nextInt() - 1;
        int missions = sc.nextInt();
        graph = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int weight = sc.nextInt();
            graph[x][y] = weight;
        }
        for (int i = 0; i < missions; i++) {
            int answer = 0;
            int one = sc.nextInt() - 1;
            int two = sc.nextInt() - 1;
            dijkstra(one);
            answer += distances[midDest];
            dijkstra(midDest);
            answer += distances[two];
            System.out.println(answer);
        }
    }

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
        visited = new boolean[graph.length];
        distances = new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;
        for (int i = 0; i < graph.length; i++) {
            int u = min_Distance();
            visited[u] = true;
            for (int j = 0; j < graph.length; j++) {
                if (!visited[j] && graph[u][j] != 0 && distances[u] + graph[u][j] < distances[j]) {
                    distances[j] = distances[u] + graph[u][j];
                }
            }
        }
    }

}
