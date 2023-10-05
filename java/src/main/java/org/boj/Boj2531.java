package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] sushi = new int[n];
        int[] eat = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        eat[c]++;
        for (int i = 0; i < k; i++) {
            if (eat[sushi[i]] == 0) {
                cnt++;
            }

            eat[sushi[i]]++;
        }

        int max = cnt;
        for (int i = 1; i < n; i++) {
            int start = i - 1;
            eat[sushi[start]]--;

            if (eat[sushi[start]] == 0) {
                cnt--;
            }

            int end = i + k - 1;
            if (end >= n) end -= n;

            if (eat[sushi[end]] == 0) {
                cnt++;
                max = Math.max(cnt, max);
            }
            eat[sushi[end]]++;
        }

        System.out.println(max);
    }
}
