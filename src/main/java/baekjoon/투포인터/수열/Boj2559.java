package baekjoon.투포인터.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[N];

        st = new StringTokenizer(br.readLine());

        int answer, sum = 0;
        for (int i = 0; i < K; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            sum += temperatures[i];
        }
        answer = sum;

        for (int i = K; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            sum += temperatures[i];
            sum -= temperatures[i - K];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
