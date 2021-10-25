package baekjoon.그래프.미로_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2178 {
    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] cells = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(cells[j]);
            }
        }

        bfs();

        System.out.println(maze[n - 1][m - 1]);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] currentLocation = queue.poll();
            int i = currentLocation[0];
            int j = currentLocation[1];

            if (i + 1 < maze.length && !visited[i + 1][j] && maze[i + 1][j] != 0) {
                visited[i + 1][j] = true;
                maze[i + 1][j] = maze[i][j] + 1;
                queue.add(new int[]{i + 1, j});
            }
            if (i > 0 && !visited[i - 1][j] && maze[i - 1][j] != 0) {
                visited[i - 1][j] = true;
                maze[i - 1][j] = maze[i][j] + 1;
                queue.add(new int[]{i - 1, j});
            }
            if (j + 1 < maze[0].length && !visited[i][j + 1] && maze[i][j + 1] != 0) {
                visited[i][j + 1] = true;
                maze[i][j + 1] = maze[i][j] + 1;
                queue.add(new int[]{i, j + 1});
            }
            if (j > 0 && !visited[i][j - 1] && maze[i][j - 1] != 0) {
                visited[i][j - 1] = true;
                maze[i][j - 1] = maze[i][j] + 1;
                queue.add(new int[]{i, j - 1});
            }
        }
    }
}
