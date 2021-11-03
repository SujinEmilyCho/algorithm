package baekjoon.그래프.연결_요소의_개수;

import java.util.Scanner;

public class Boj11724 {
    private static boolean[][] edges;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        edges = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] edge = sc.nextLine().split(" ");
            int node1 = Integer.parseInt(edge[0]);
            int node2 = Integer.parseInt(edge[1]);

            edges[node1][node2] = true;
            edges[node2][node1] = true;
        }

        System.out.println(solve());
    }

    public static int solve() {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        return result;
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && edges[node][i]) {
                dfs(i);
            }
        }
    }
}
