package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9079 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static boolean[][][] map;
    static int min;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        map = new boolean[T][3][3];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < 3; k++) {
                    map[i][j][k] = convert(input[k]);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            min = Integer.MAX_VALUE;
            findMinimum(map[i]);
            System.out.println(min);
        }
    }

    static void findMinimum(boolean[][] coins) {
        if (check(coins)) {
            min = Math.min(min, 0);
            return;
        }

        for (int i = 0; i < (1 << 8); i++) {
            boolean[][] newCoins = arrayDump(coins);
            int cnt = 0;
            for (int j = 0; j < 8; j++) {
                if ((i & (1 << j)) != 0) {
                    swap(newCoins, j);
                    cnt++;
                }
            }
            if (check(newCoins)) {
                min = Math.min(min, cnt);
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
    }

    private static boolean[][] arrayDump(boolean[][] coins) {
        boolean[][] dump = new boolean[3][3];

        for (int i = 0; i < 3; i++) {
            System.arraycopy(coins[i], 0, dump[i], 0, 3);
        }

        return dump;
    }

    static void swap(boolean[][] coins, int depth) {
        if (depth < 3) {
            for (int i = 0; i < 3; i++) {
                coins[i][depth] = !coins[i][depth];
            }
        } else if (depth < 6) {
            for (int i = 0; i < 3; i++) {
                coins[depth - 3][i] = !coins[depth - 3][i];
            }
        } else if (depth == 6) {
            for (int i = 0; i < 3; i++) {
                coins[i][i] = !coins[i][i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                coins[i][2 - i] = !coins[i][2 - i];
            }
        }
    }

    static boolean convert(String input) {
        return input.equals("T") ? true : false;
    }

    static boolean check(boolean[][] target) {
        boolean type = target[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (type != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}