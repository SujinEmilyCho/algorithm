package baekjoon.이진검색.용돈_관리;

import java.util.Scanner;

public class Boj6236 {
    private static int[] budgets;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        budgets = new int[N];

        int totalBudget = 0;
        int maxBudget = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = sc.nextInt();
            totalBudget += budgets[i];
            maxBudget = Math.max(maxBudget, budgets[i]);
        }

        int l = maxBudget, r = totalBudget, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (isPossible(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(l);
    }

    public static boolean isPossible(int m) {
        int times = 0;
        int budget = 0;

        for (int i = 0; i < budgets.length; i++) {
            if (budgets.length - i + times <= M) return true;
            if (budget < budgets[i]) {
                budget = m;
                times++;
            }
            budget -= budgets[i];
        }
        return times <= M;
    }
}
