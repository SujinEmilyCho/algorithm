package baekjoon.브루트포스.체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    private static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        int answer = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, countBlocksToChange(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int countBlocksToChange(int xStart, int yStart) {
        int answer = 0;
        for (int i = xStart; i < xStart + 8; i++) {
            for (int j = yStart; j < yStart + 8; j++) {
                if ((i + j) % 2 == 0 && "B".equals(board[i][j])) {
                    answer++;
                } else if ((i + j) % 2 == 1 && "W".equals(board[i][j])) {
                    answer++;
                }
            }
        }
        return Math.min(answer, 64 - answer);
    }
}
