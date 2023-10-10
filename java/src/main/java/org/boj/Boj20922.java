package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] cache = new int[100_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;

        while (start <= end) {
            if (end <= n - 1 && cache[arr[end]] < k) {
                cache[arr[end]]++;
                end++;
            }

            else {
                cache[arr[start]]--;
                start++;
            }

            max = Math.max(max, end - start);

            if (end == n) break;
        }

        System.out.println(max);
    }
}
