package baekjoon.투포인터.회전_초밥;

import java.util.Scanner;

public class Boj2531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] selectedSushi = new int[d + 1];
        int[] sushi = new int[N + k];

        for (int i = 0; i < N; i++) {
            sushi[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            sushi[N + i] = sushi[i];
        }

        selectedSushi[c] = 1;
        int diversity = 1;
        int l = 0, r = 0, answer = 0;
        while (l < N) {
            if (r >= k) {
                int sushiToCancel = sushi[l];
                if (selectedSushi[sushiToCancel] == 1) {
                    diversity--;
                }
                selectedSushi[sushiToCancel]--;
                l++;
            }

            int sushiToSelect = sushi[r];
            if (selectedSushi[sushiToSelect] == 0) {
                diversity++;
            }
            selectedSushi[sushiToSelect]++;
            r++;

            answer = Math.max(answer, diversity);
        }

        System.out.println(answer);
    }
}
