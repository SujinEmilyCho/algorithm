package programmers.위클리챌린지;

public class Week8 {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;

        for (int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }

        return w * h;
    }
}
