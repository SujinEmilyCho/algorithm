package baekjoon.트리.완전_이진_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9934 {
    private static int[] visitOrder;
    private static List<List<Integer>> village = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        visitOrder = new int[(int) Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < visitOrder.length; i++) {
            visitOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            village.add(new ArrayList<>());
        }

        solve(0, visitOrder.length - 1, 0);

        for (List<Integer> buildings : village) {
            for (Integer building : buildings) {
                System.out.print(building + " ");
            }
            System.out.println();
        }
    }

    public static void solve(int start, int end, int depth) {
        if (start == end) {
            village.get(depth).add(visitOrder[start]);
        } else {
            int mid = (start + end) / 2;
            village.get(depth).add(visitOrder[mid]);
            solve(start, mid - 1, depth + 1);
            solve(mid + 1, end, depth + 1);
        }
    }
}
