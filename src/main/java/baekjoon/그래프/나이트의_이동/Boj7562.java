package baekjoon.그래프.나이트의_이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj7562 {
    private static int n;
    private static int[][] check;
    private static int targetY;
    private static int targetX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(sc.nextLine());
            check = new int[n][n];

            String[] current = sc.nextLine().split(" ");
            int y = Integer.parseInt(current[0]);
            int x = Integer.parseInt(current[1]);

            String[] target = sc.nextLine().split(" ");
            targetY = Integer.parseInt(target[0]);
            targetX = Integer.parseInt(target[1]);

            System.out.println(bfs(x, y));
        }
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            int moveCnt = check[y][x];

            if (targetX == x && targetY == y) return moveCnt;

            if (y + 2 < n && x + 1 < n && check[y + 2][x + 1] == 0) {
                q.add(new int[]{y + 2, x + 1});
                check[y + 2][x + 1] = moveCnt + 1;
            }
            if (y + 2 < n && x - 1 >= 0 && check[y + 2][x - 1] == 0) {
                q.add(new int[]{y + 2, x - 1});
                check[y + 2][x - 1] = moveCnt + 1;
            }
            if (y - 2 >= 0 && x + 1 < n && check[y - 2][x + 1] == 0) {
                q.add(new int[]{y - 2, x + 1});
                check[y - 2][x + 1] = moveCnt + 1;
            }
            if (y - 2 >= 0 && x - 1 >= 0 && check[y - 2][x - 1] == 0) {
                q.add(new int[]{y - 2, x - 1});
                check[y - 2][x - 1] = moveCnt + 1;
            }
            if (y + 1 < n && x + 2 < n && check[y + 1][x + 2] == 0) {
                q.add(new int[]{y + 1, x + 2});
                check[y + 1][x + 2] = moveCnt + 1;
            }
            if (y - 1 >= 0 && x + 2 < n && check[y - 1][x + 2] == 0) {
                q.add(new int[]{y - 1, x + 2});
                check[y - 1][x + 2] = moveCnt + 1;
            }
            if (y + 1 < n && x - 2 >= 0 && check[y + 1][x - 2] == 0) {
                q.add(new int[]{y + 1, x - 2});
                check[y + 1][x - 2] = moveCnt + 1;
            }
            if (y - 1 >= 0 && x - 2 >= 0 && check[y - 1][x - 2] == 0) {
                q.add(new int[]{y - 1, x - 2});
                check[y - 1][x - 2] = moveCnt + 1;
            }
        }
        return 0;
    }
}
