package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] bucket = new int[1_000_001];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            bucket[idx] = ice;
            min = Math.min(min, idx);
            max = Math.max(max, idx);
        }

        int sum = bucket[min];
        for (int i = 1; i < k; i++) {
            if (min + i < 1_000_001) {
                sum += bucket[min + i];
            }

            if (min - i >= 0) {
                sum += bucket[min - i];
            }
        }

        int sumMax = sum;
        for (int i = min; i <= max; i++) {
            int start = i - k;
            int end = i + k;

            if (end < 1_000_001) {
                sum += bucket[end];
            }

            sumMax = Math.max(sum, sumMax);

            if (start >= 0) {
                sum -= bucket[start];
            }
        }

        System.out.println(sumMax);
    }
}
