package baekjoon.트리.상근이의_여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            solve(br);
        }
    }

    public static void solve2(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] table = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            table[a][b] = true;
            table[b][a] = true;
        }

        System.out.println(N - 1);
    }


    private static void solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N + 1];
        int[][] routes = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int country1 = Integer.parseInt(st.nextToken());
            int country2 = Integer.parseInt(st.nextToken());

            routes[country1][country2] = 1;
            routes[country2][country1] = 1;
        }

        int answer = bfs(visit, routes);
        System.out.println(answer);
    }

    private static int bfs(boolean[] visit, int[][] routes) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            Integer departure = queue.poll();

            for (int i = 1; i < routes.length; i++) {
                if (!visit[i] && routes[departure][i] == 1) {
                    queue.add(i);
                    visit[i] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
