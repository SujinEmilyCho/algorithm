package baekjoon.이진검색.정수_제곱근;

import java.util.Scanner;

public class Boj2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long answer = binarySearch(n);
        System.out.println(answer);

    }

    public static long solve(long n) {
        double q = Math.sqrt(n);
        return (long) Math.ceil(q);
    }

    public static long binarySearch(long n) {
        long l = 0;
        long r = n - 1;
        long m = (l + r) / 2;

        while (l <= r) {
            if (m > Math.sqrt(n)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = (l + r) / 2;
        }

        return l;
    }
}
