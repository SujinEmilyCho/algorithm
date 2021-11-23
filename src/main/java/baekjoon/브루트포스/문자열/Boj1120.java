package baekjoon.브루트포스.문자열;

import java.util.Scanner;

public class Boj1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int minDiff = A.length();
        int lengthDiff = B.length() - A.length();
        for (int i = 0; i <= lengthDiff; i++) {
            int diff = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) diff++;
            }
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}
