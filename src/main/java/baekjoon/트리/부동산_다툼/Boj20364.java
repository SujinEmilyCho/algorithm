package baekjoon.트리.부동산_다툼;

import java.util.Scanner;

public class Boj20364 {
    private static int[] visited;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] info = sc.nextLine().split(" ");
        N = Integer.parseInt(info[0]);
        visited = new int[N + 1];

        int Q = Integer.parseInt(info[1]);

        for (int i = 0; i < Q; i++) {
            int land = sc.nextInt();
            solve2(land);
        }
    }

    public static void solve(int target, int current) {
        if (current > target) return;

        if (visited[current] == 1) {
            System.out.println(current);
        } else if (current == target) {
            visited[current] = 1;
            System.out.println(0);
        } else {
            int next = target;
            while (next > (current * 2) + 1) {
                next /= 2;
            }
            solve(target, next);
        }
    }

    public static void solve2(int target) {
        if (visited[target] == 0) {
            visited[target] = target;
            dfs(target * 2, target);
            dfs(target * 2 + 1, target);
            System.out.println(0);
        } else {
            System.out.println(visited[target]);
        }
    }

    public static void dfs(int current, int value) {
        if (current > N) return;

        visited[current] = value;
        dfs(current * 2, value);
        dfs(current * 2 + 1, value);
    }
}
