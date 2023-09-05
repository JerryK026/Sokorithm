package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            HashSet<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
