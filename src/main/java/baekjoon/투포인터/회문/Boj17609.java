package baekjoon.투포인터.회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int answer = checkPalindrome(br.readLine());
            System.out.println(answer);
        }
    }

    public static int checkPalindrome(String word) {
        int l = 0, r = word.length() - 1, differences = 0;
        while (l <= r) {
            if (word.charAt(l) == word.charAt(r)) {
                l += 1;
                r -= 1;
            } else {
                differences++;
                l++;
            }
        }

        l = 0;
        r = word.length() - 1;
        int differences2 = 0;
        while (l <= r) {
            if (word.charAt(l) == word.charAt(r)) {
                l += 1;
                r -= 1;
            } else {
                differences2++;
                r--;
            }
        }

        int answer = Math.min(differences, differences2);
        return answer > 1 ? 2 : answer;
    }
}
