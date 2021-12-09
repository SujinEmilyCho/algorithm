package baekjoon.투포인터.귀여운_라이언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        int[] dolls = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int lions = dolls[0] == 1 ? 1 : 0, answer = N, l = 0, r = 0;
        while (r < N) {
            if (lions == K) {
                answer = Math.min(answer, r - l + 1);
                if (dolls[l] == 1) lions--;
                l++;
            } else if (lions < K) {
                r++;
                if (dolls[r] == 1) lions++;
            }
        }

        System.out.println(answer == N ? -1 : answer);
    }
}
