package baekjoon.브루트포스.일곱_난쟁이;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Obj2309 {
    public static void main(String[] args) {
        List<Integer> heights = new ArrayList<>();
        int totalHeight = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            int height = sc.nextInt();
            heights.add(height);
            totalHeight += height;
        }

        int dwarf1 = 0, dwarf2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (i == j) continue;
                if (totalHeight - (heights.get(i) + heights.get(j)) == 100) {
                    dwarf1 = i;
                    dwarf2 = j;
                    break;
                }
            }
        }

        heights.remove(dwarf2);
        heights.remove(dwarf1);
        heights.sort(Comparator.naturalOrder());

        for (int i = 0; i < 7; i++) {
            System.out.println(heights.get(i));
        }
    }
}
