package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2343 {
    static int N, M;
    static int[] videos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        videos = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            sum += videos[i];
            max = Math.max(max, videos[i]);
        }

        System.out.println(binSearch(max, sum));
    }

    static int binSearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                sum += videos[i];
                if (sum > mid) {
                    sum = videos[i];
                    cnt++;
                }
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
