package baekjoon.이진검색.보석_상자;

import java.util.Scanner;

public class Boj2792 {
    private static int[] gems;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        gems = new int[M];

        int maxJealous = 0;
        for (int i = 0; i < M; i++) {
            gems[i] = sc.nextInt();
            maxJealous = Math.max(maxJealous, gems[i]);
        }

        int l = 1, r = maxJealous, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (isPossible(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean isPossible(int m) {
        int people = 0;

        for (int i = 0; i < gems.length; i++) {
            people += gems[i] / m;
            if (gems[i] % m != 0) people++;
        }

        return people <= N;
    }
}
