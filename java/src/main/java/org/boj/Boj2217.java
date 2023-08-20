package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int lopes[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        lopes = new int[N];
        for (int i = 0; i < N; i++) {
            lopes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lopes);

        for (int i = 0; i < N; i++) {
            max = Math.max(max, (lopes[i] * (N - i)));
        }

        System.out.println(max);
    }
}
