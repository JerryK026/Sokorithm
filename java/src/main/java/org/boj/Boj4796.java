package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        int i = 1;
        while (flag) {
            int[] lpv = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int l = lpv[0];
            int p = lpv[1];
            int v = lpv[2];

            if (l == 0 && p == 0 && v == 0) {
                flag = false;
                continue;
            }

            int result = (l * (v / p));
            result += l > v % p ? v % p : l;

            System.out.println(String.format("Case %d: %d", i++, result));
        }
    }
}
