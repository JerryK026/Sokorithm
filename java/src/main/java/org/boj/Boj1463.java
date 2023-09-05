package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3, 2 2, 1 2 2, 3 2, 1 3 2, 2 1 3, 3 3, 1 3 3, 1 1 3 3, 3 1 3
 */
public class Boj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N + 2];

        ans[1] = 0;
        for (int i = 2; i <= N; i++) {
            ans[i] = ans[i - 1] + 1;

            if (i % 3 == 0) {
                ans[i] = Math.min(ans[i], ans[i / 3] + 1);
            }

            if (i % 2 == 0) {
                ans[i] = Math.min(ans[i], ans[i / 2] + 1);
            }
        }

        System.out.println(ans[N]);
    }
}
