package baekjoon.이진검색.수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static int N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            if (isIncluded(Integer.parseInt(st.nextToken()))) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(LINE_SEPARATOR);
        }

        System.out.println(sb.toString());
    }

    public static boolean isIncluded(int n) {
        int l = 0, r = N - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (n == numbers[mid]) {
                return true;
            } else if (n > numbers[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
