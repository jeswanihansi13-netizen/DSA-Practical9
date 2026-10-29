
import java.util.Scanner;

public class GraphTraversal {

    static int[][] adjMatrix;
    static boolean[] visited;
    static int vertices;

    // Breadth First Search using a queue
    static void BFS(int start) {
        visited = new boolean[vertices];
        int[] queue = new int[vertices];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS Traversal: ");

        while (front < rear) {
            int current = queue[front++];
            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue[rear++] = i;
                }
            }
        }

        System.out.println();
    }

    // Depth First Search using recursion
    static void DFSUtil(int current) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[current][i] == 1 && !visited[i]) {
                DFSUtil(i);
            }
        }
    }

    static void DFS(int start) {
        visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");
        DFSUtil(start);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        vertices = sc.nextInt();

        if (vertices <= 0) {
            System.out.println("Number of cities must be positive.");
            sc.close();
            return;
        }

        adjMatrix = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix (0 or 1):");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting city (0 to "
                + (vertices - 1) + "): ");
        int start = sc.nextInt();

        if (start < 0 || start >= vertices) {
            System.out.println("Invalid starting city.");
            sc.close();
            return;
        }

        BFS(start);
        DFS(start);

        sc.close();
    }
}
