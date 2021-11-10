package baekjoon.투포인터.배열_합치기;

import java.io.*;
import java.util.StringTokenizer;

public class Boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int pointerA = 0, pointerB = 0;
        while (pointerA <= n && pointerB <= m) {
            if (pointerA == n && pointerB == m) break;
            if (pointerA == n) {
                bw.write(b[pointerB++] + " ");
            } else if (pointerB == m) {
                bw.write(a[pointerA++] + " ");
            } else if (a[pointerA] < b[pointerB]) {
                bw.write(a[pointerA++] + " ");
            } else {
                bw.write(b[pointerB++] + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
