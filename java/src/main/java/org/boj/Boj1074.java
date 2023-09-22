package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행, 열은 0부터 센다
public class Boj1074 {
    static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int end = (int) Math.pow(2, N) - 1;
        find(0, end, 0, end, N, 0);
    }

    static void find(int rStart, int rEnd, int cStart, int cEnd, int level, long value) {
        if (level == 0) {
            System.out.println(value);
            System.exit(0);
        }

        int rBound = (rStart + rEnd) / 2;
        int cBound = (cStart + cEnd) / 2;

        int alpha = (int) Math.pow(2, 2 * (level - 1));
        if (rStart <= r && r <= rBound && cStart <= c && c <= cBound) {
            find(rStart, rBound, cStart, cBound, level - 1, value);
        } else if (rStart <= r && r <= rBound && cBound < c && c <= cEnd) {
            find(rStart, rBound, cBound + 1, cEnd, level - 1, value + alpha);
        } else if (rBound < r && r <= rEnd && cStart <= c && c <= cBound) {
            find(rBound + 1, rEnd, cStart, cBound, level - 1, value + (alpha * 2));
        } else if (rBound < r && r <= rEnd && cBound < c && c <= cEnd) {
            find(rBound + 1, rEnd, cBound + 1, cEnd, level - 1, value + (alpha * 3));
        }
    }
}
