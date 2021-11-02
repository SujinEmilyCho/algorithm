package baekjoon.그래프.유기농_배추;

import java.util.Scanner;

public class Boj1012 {
    private static boolean[][] field;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] info = sc.nextLine().split(" ");
            int m = Integer.parseInt(info[0]);
            int n = Integer.parseInt(info[1]);
            int k = Integer.parseInt(info[2]);

            field = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                String[] location = sc.nextLine().split(" ");
                int x = Integer.parseInt(location[0]);
                int y = Integer.parseInt(location[1]);
                field[y][x] = true;
            }

            System.out.println(solve(m, n));
        }
    }

    private static int solve(int m, int n) {
        int result = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (field[y][x]) {
                    dfs(x, y);
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(int x, int y) {
        field[y][x] = false;

        if (x + 1 < field[0].length && field[y][x + 1]) {
            dfs(x + 1, y);
        }
        if (x - 1 >= 0 && field[y][x - 1]) {
            dfs(x - 1, y);
        }
        if (y + 1 < field.length && field[y + 1][x]) {
            dfs(x, y + 1);
        }
        if (y - 1 >= 0 && field[y - 1][x]) {
            dfs(x, y - 1);
        }
    }
}
