package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj14425 {
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
        for (int j = 0; j < M; j++) {
            if (db.contains(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
