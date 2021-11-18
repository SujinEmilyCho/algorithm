package baekjoon.다이나믹_프로그래밍.타일_장식물;

import java.util.Scanner;

public class Boj13301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] tiles = new long[N + 2];
        tiles[1] = 1;
        tiles[2] = 1;

        for (int i = 3; i <= N; i++) {
            tiles[i] = tiles[i - 1] + tiles[i - 2];
        }

        long area = 2 * (tiles[N] + tiles[N] + tiles[N - 1]);
        System.out.println(area);
    }
}
