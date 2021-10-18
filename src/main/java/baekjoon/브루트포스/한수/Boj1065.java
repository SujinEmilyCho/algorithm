package baekjoon.브루트포스.한수;

import java.util.Scanner;

/* problem 1065
 * 브루트포스: 완전 탐색. 모든 경우의 수를 탐색하면서 요구조건에 충족되는 해를 찾는 알고리즘.
 *
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 *
 * 입력: 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 *
 * 출력: 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 * */
public class Boj1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(count한수(n));
    }

    public static int count한수(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (is한수(i)) {
                result++;
            }
        }
        return result;
    }

    public static boolean is한수(int n) {
        int previous = n % 10;
        int current = (n / 10) % 10;
        int difference = previous - current;

        while (n > 99) {
            n /= 10;

            previous = n % 10;
            current = (n / 10) % 10;
            if (difference != previous - current) {
                return false;
            }
        }

        return true;
    }
}
