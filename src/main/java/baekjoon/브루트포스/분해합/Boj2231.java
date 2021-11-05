package baekjoon.브루트포스.분해합;

import java.util.Scanner;

public class Boj2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int length = input.length();
        int n = Integer.parseInt(input);

        System.out.println(solve(length, n));
    }

    private static int solve(int length, int n) {
        for (int m = n - 9 * length; m <= n; m++) {
            if (decompose(m) == n) {
                return m;
            }
        }
        return 0;

    }

    private static int decompose(int m) {
        int total = m;

        while (m > 0) {
            total += m % 10;
            m /= 10;
        }

        return total;
    }
}
