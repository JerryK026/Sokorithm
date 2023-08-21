package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11047 {
    static int N, K;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (sum < K) {
                cnt += (K - sum) / coins[i];
                sum += ((K - sum) / coins[i]) * coins[i];
            }
        }

        System.out.println(cnt);
    }
}
