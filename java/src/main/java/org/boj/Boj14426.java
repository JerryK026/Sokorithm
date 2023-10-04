package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] targets = new String[n];
        HashSet<String>[] sets = new HashSet[501];
        for (int i = 1; i < 501; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            targets[i] = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < targets[i].length(); j++) {
                sb.append(targets[i].charAt(j));
                sets[j + 1].add(sb.toString());
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (sets[input.length()].contains(input)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
