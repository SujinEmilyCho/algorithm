package baekjoon.정렬.좌표_정렬하기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Boj11650 {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]> coordinates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] point = {sc.nextInt(), sc.nextInt()};
            coordinates.add(point);
        }

        coordinates.sort(Comparator.<int[], Integer>comparing(p -> p[0]).thenComparing(p -> p[1]));

        StringBuilder sb = new StringBuilder();
        for (int[] points : coordinates) {
            sb.append(points[0]);
            sb.append(" ");
            sb.append(points[1]);
            sb.append(LINE_SEPARATOR);
        }
        System.out.println(sb.toString());
    }
}
