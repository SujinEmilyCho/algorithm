package baekjoon.그래프.섬의_개수;

import java.util.Scanner;

public class Boj4963 {
    private static int[][] map;
    private static int w;
    private static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] test = sc.nextLine().split(" ");
            w = Integer.parseInt(test[0]);
            h = Integer.parseInt(test[1]);

            if (w == 0 && h == 0) break;

            map = new int[h][w];

            init(sc);
            System.out.println(solve());
        }
    }

    private static void init(Scanner sc) {
        for (int i = 0; i < h; i++) {
            String[] info = sc.nextLine().split(" ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(info[j]);
            }
        }
    }

    public static int solve() {
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(int i, int j) {
        map[i][j] = 0;

        for (int ii = -1; ii <= 1; ii++) {
            for (int jj = -1; jj <= 1; jj++) {
                if (i + ii < 0 || i + ii >= h || j + jj < 0 || j + jj >= w) continue;
                if (map[i + ii][j + jj] == 1) dfs(i + ii, j + jj);
            }
        }
    }
}
