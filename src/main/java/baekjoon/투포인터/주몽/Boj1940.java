package baekjoon.투포인터.주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] materials = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);

        int pointer1 = 0, pointer2 = n - 1;
        int result = 0;
        while (pointer1 < pointer2) {
            int sum = materials[pointer1] + materials[pointer2];
            if (sum == m) {
                result++;
                pointer1++;
                pointer2--;
            } else if (sum > m) {
                pointer2--;
            } else {
                pointer1++;
            }

        }

        System.out.println(result);
    }
}
