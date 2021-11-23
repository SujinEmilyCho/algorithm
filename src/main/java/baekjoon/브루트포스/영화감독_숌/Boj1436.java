package baekjoon.브루트포스.영화감독_숌;

import java.util.Scanner;

public class Boj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 665;

        while (N > 0) {
            answer++;
            if (isMatched(answer)) {
                N--;
            }
        }
        System.out.println(answer);
    }

    private static boolean isMatched(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 6) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) return true;
            n /= 10;
        }

        return false;
    }
}
