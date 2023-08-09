package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i <= N; i++) {
            int sum = Arrays.stream(String.valueOf(i).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum() + i;

            if (N == sum) {
                System.out.println(i);
                System.exit(0);
            }
        }

        System.out.println(result);
    }
}
