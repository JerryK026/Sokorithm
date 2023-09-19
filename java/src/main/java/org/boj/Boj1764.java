package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> db = new HashSet<>();

        for (int i = 0; i < N; i++) {
            db.add(br.readLine());
        }

        int cnt = 0;
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (db.contains(input)) {
                cnt++;
                output.add(input);
            }
        }

        Collections.sort(output);

        output.stream().map(s -> sb.append(s).append("\n"));

        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }
}
