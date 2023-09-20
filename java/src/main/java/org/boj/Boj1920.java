package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> db = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            db.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (db.contains(st.nextToken())) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
