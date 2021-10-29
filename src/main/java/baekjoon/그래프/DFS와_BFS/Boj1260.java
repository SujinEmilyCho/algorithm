package baekjoon.그래프.DFS와_BFS;

import java.util.*;

public class Boj1260 {
    private static int[][] edges;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        sc.nextLine();

        edges = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] edge = sc.nextLine().split(" ");
            int node1 = Integer.parseInt(edge[0]);
            int node2 = Integer.parseInt(edge[1]);
            edges[node1][node2] = 1;
            edges[node2][node1] = 1;
        }

        visited = new boolean[n + 1];
        System.out.println(dfs(v));

        visited = new boolean[n + 1];
        System.out.println(bfs(v));
    }

    public static String dfs(int start) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                stringJoiner.add(String.valueOf(current));

                for (int i = edges.length - 1; i > 0; i--) {
                    if (edges[current][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return stringJoiner.toString();
    }

    public static void dfs2(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 1; i < visited.length; i++) {
            if (edges[start][i] == 1 && !visited[i]) {
                dfs2(i);
            }
        }
    }

    public static String bfs(int start) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            stringJoiner.add(String.valueOf(current));
            for (int i = 1; i < edges.length; i++) {
                if (edges[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return stringJoiner.toString();
    }
}
