package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = new int[n];
        int[] sum = new int[n];

        String[] input = br.readLine().split(" ");
        arr[0] = Integer.parseInt(input[0]);
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sum[i] = sum[i - 1] + arr[i];
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = sum[i] - sum[j] + arr[j];
                if (cur == m) {
                    cnt++;
                    break;
                }

                if (cur < m) {
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
