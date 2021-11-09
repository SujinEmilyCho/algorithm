package baekjoon.정렬.콘테스트;

import java.util.Arrays;
import java.util.Scanner;

public class Boj5576 {
    public static void main(String[] args) {
        int[] wScores = new int[10];
        int[] kScores = new int[10];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            wScores[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            kScores[i] = sc.nextInt();
        }

        Arrays.sort(wScores);
        Arrays.sort(kScores);

        int wScore = wScores[9] + wScores[8] + wScores[7];
        int kScore = kScores[9] + kScores[8] + kScores[7];

        System.out.println(wScore + " " + kScore);
    }
}
