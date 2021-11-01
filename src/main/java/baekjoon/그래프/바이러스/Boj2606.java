package baekjoon.그래프.바이러스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606 {
    private static int[][] matrix;
    private static boolean[] checked;
    private static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        matrix = new int[n + 1][n + 1];
        checked = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] edge = sc.nextLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        dfs(1);
        System.out.println(result);
    }

    public static void dfs(int node) {
        checked[node] = true;
        result += 1;

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && !checked[i]) {
                dfs(i);
            }
        }
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int result = -1;

        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (!checked[current]) {
                checked[current] = true;
                result++;
            }

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[current][i] == 1 && !checked[i]) {
                    q.add(i);
                }
            }
        }

        return result;
    }
}
