package baekjoon.다이나믹_프로그래밍.BABBA;

import java.util.Scanner;

public class Boj9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int a = 1;
        int b = 0;
        for (int i = 0; i < K; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }

        System.out.println(a + " " + b);
    }
}
