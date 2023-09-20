package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[N];

        int right = 0;
        int left = 0;
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            right += day[i];
            left = Math.max(left, day[i]);
        }

        while (left <= right) {
            int sum = 0;
            int cnt = 1;
            int mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                sum += day[i];
                if (sum > mid) {
                    sum = day[i];
                    cnt++;
                }
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
