package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 첫번째 spot부터 하나씩 세면서 spot[i] - spot[i-1] < l - 1이면 spot[i-1]저장
 * spot[k] - spot[i-1] >= l - 1이라면 cnt++;
 */
public class Boj1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nl = br.readLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);

        int[] spots = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(spots);

        int last = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (spots[i]  > last) {
                cnt++;
                last = spots[i] + l - 1;
            }
        }

        System.out.println(cnt);
    }
}