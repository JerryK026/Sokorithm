package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] groupA = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] groupB = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(groupB);

            int cnt = 0;

            for (int j = 0; j < N; j++) {
                int a = groupA[j];

                int left = 0, right = M - 1;
                int mid = 0;
                while (left <= right) {
                    mid = (left + right) / 2;

                    if (a > groupB[mid]) {
                        left = mid + 1;
                        continue;
                    }

                    right = mid - 1;
                }

                if (a > groupB[mid]) {
                    cnt += mid + 1;
                    continue;
                }

                cnt += mid;
            }

            System.out.println(cnt);
        }
    }
}
