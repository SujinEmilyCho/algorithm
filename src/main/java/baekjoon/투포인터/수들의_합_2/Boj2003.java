package baekjoon.투포인터.수들의_합_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {
    private static int N;
    private static int M;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    public static int solve() {
        int l = 0, r = 0, sum = numbers[0], cases = 0;
        while (r < N) {
            if (sum == M) {
                cases++;
                sum -= numbers[l++];
            } else if (sum < M) {
                sum += numbers[++r];
            } else {
                sum -= numbers[l++];
            }
        }
        return cases;
    }

    public static int solve2() {
        int l = 0, r = 0, sum = numbers[0], cases = 0;
        while (l <= r && r < N) {
            if (sum == M) {
                cases++;
                sum -= numbers[l];
                l++;
                r++;
                if (r < N) {
                    sum += numbers[r];
                }
            } else if (sum < M) {
                r++;
                if (r < N) {
                    sum += numbers[r];
                }
            } else {
                sum -= numbers[l];
                l++;
                if (l > r && r + 1 < N) {
                    r++;
                    sum += numbers[r];
                }
            }
        }
        return cases;
    }
}
