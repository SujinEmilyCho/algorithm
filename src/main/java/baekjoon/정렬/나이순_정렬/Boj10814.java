package baekjoon.정렬.나이순_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Boj10814 {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<User> users = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            users.add(new User(info[0], info[1]));
        }

        users.sort(Comparator.comparing(User::getAge));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(users.get(i));
            sb.append(LINE_SEPARATOR);
        }
        System.out.println(sb.toString());
    }

    static class User {
        private final int age;
        private final String name;

        User(String age, String name) {
            this.age = Integer.parseInt(age);
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
