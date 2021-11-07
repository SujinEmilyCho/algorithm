package baekjoon.정렬.세수정렬;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2752 {
    public static void main(String[] args) {
        int[] numbers = new int[3];

        Scanner sc = new Scanner(System.in);
        numbers[0] = sc.nextInt();
        numbers[1] = sc.nextInt();
        numbers[2] = sc.nextInt();

        Arrays.sort(numbers);

        String result = numbers[0] + " " + numbers[1] + " " + numbers[2];
        System.out.println(result);
    }
}
