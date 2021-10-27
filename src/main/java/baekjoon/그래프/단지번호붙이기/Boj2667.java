package baekjoon.그래프.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2667 {
    private static int n;
    private static int[][] houses;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        List<Integer> results = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        houses = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] numbers = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                houses[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && houses[i][j] == 1) {
                    results.add(bfs(i, j));
                }
            }
        }

        results.sort(Comparator.naturalOrder());
        buffer.append(results.size()).append("\n");
        for (int result : results) {
            buffer.append(result).append("\n");
        }
        System.out.println(buffer.toString());
    }

    public static int bfs(int x, int y) {
        Queue<int[]> complex = new LinkedList<>();
        complex.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!complex.isEmpty()) {
            int[] location = complex.poll();
            int i = location[0];
            int j = location[1];

            if (i + 1 < n && !visited[i + 1][j] && houses[i + 1][j] == 1) {
                cnt++;
                visited[i + 1][j] = true;
                complex.add(new int[]{i + 1, j});
            }
            if (i - 1 >= 0 && !visited[i - 1][j] && houses[i - 1][j] == 1) {
                cnt++;
                visited[i - 1][j] = true;
                complex.add(new int[]{i - 1, j});
            }
            if (j + 1 < n && !visited[i][j + 1] && houses[i][j + 1] == 1) {
                cnt++;
                visited[i][j + 1] = true;
                complex.add(new int[]{i, j + 1});
            }
            if (j - 1 >= 0 && !visited[i][j - 1] && houses[i][j - 1] == 1) {
                cnt++;
                visited[i][j - 1] = true;
                complex.add(new int[]{i, j - 1});
            }
        }

        return cnt;
    }
}
