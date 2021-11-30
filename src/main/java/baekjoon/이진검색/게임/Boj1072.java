package baekjoon.이진검색.게임;

import java.util.Scanner;

public class Boj1072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = calculateWinRate(X, Y);

        if (Z == 100 || Z == 99) {
            System.out.println(-1);
            return;
        }

        System.out.println(solve(X, Y, Z));
    }

    public static int solve(int x, int y, int z) {
        int l = 0, r = 1000000000, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            int new_z = calculateWinRate(x + m, y + m);
            if (new_z <= z) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static int calculateWinRate(long x, long y) {
        return (int) (y * 100 / x);
    }
}
