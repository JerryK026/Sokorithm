package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3085 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[][] candies;
    static int max;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        candies = new String[N][];

        for (int i = 0; i < N; i++) {
            candies[i] = br.readLine().split("");
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapR(i, j);
                check();
                swapR(i, j);
                swapC(i, j);
                check();
                swapC(i, j);
            }
        }

        System.out.println(max);
    }

    static void swapR(int i, int j) {
        if (candies[i][j] == candies[i][j + 1]) return;
        String tmp = candies[i][j];
        candies[i][j] = candies[i][j + 1];
        candies[i][j + 1] = tmp;
    }

    static void swapC(int i, int j) {
        if (candies[j][i] == candies[j + 1][i]) return;
        String tmp = candies[j][i];
        candies[j][i] = candies[j + 1][i];
        candies[j + 1][i] = tmp;
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            int rCnt = 1;
            int cCnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candies[i][j].equals(candies[i][j + 1])) {
                    rCnt++;
                }
                else {
                    rCnt = 1;
                }

                if (candies[j + 1][i].equals(candies[j][i])) {
                    cCnt++;
                }
                else {
                    cCnt = 1;
                }

                max = Math.max(max, cCnt);
                max = Math.max(max, rCnt);
            }
        }
    }
}
