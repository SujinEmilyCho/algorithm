package baekjoon.투포인터.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int x = Integer.parseInt(br.readLine());

        int left = 0, right = n - 1;
        int answer = 0;

        while (left < right) {
            if (x == (numbers[left] + numbers[right])) {
                answer++;
                left++;
                right--;
            } else if (x > (numbers[left] + numbers[right])) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}
