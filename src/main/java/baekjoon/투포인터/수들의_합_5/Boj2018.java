package baekjoon.투포인터.수들의_합_5;

import java.util.Scanner;

public class Boj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solve2(N));
    }

    public static int solve1(int N) {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int nextNumber = i;
            while (sum < N && nextNumber <= N) {
                sum += (nextNumber++);
            }
            if (sum == N) answer++;
        }
        return answer;
    }

    public static int solve2(int N) {
        int left = 1;
        int right = 1;
        int sum = 1;
        int answer = 0;

        while (left <= right && right <= N) {
            if (sum == N) {
                answer++;
                sum += ++right;
                sum -= left++;
            } else if (sum < N) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        return answer;
    }
}
