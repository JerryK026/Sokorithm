package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2615 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] go = new int[19][19];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 19; i++) {
            go[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int stone = go[j][i];
                if (stone == 1) {
                    check(j, i, 1);
                } else if (stone == 2) {
                    check(j, i, 2);
                }
            }
        }

        System.out.println(0);
    }

    private static void check(int r, int c, int stone) {
        // 하단 세로
        if (!isSame(r - 1, c, stone)) {
            for (int k = 0; k < 5; k++) {
                if (!isSame(r + k, c, stone)) {
                    break;
                }

                if (k == 4) {
                    if (!isSame(r + 5, c, stone)) {
                        print(r, c, stone);
                    }
                }
            }
        }

        // 우측 가로
        if (!isSame(r, c - 1, stone)) {
            for (int k = 0; k < 5; k++) {
                if (!isSame(r, c + k, stone)) {
                    break;
                }

                if (k == 4) {
                    if (!isSame(r, c + 5, stone)) {
                        print(r, c, stone);
                    }
                }
            }
        }

        // 우측 상단 대각선
        if (!isSame(r + 1, c - 1, stone)) {
            for (int k = 0; k < 5; k++) {
                if (!isSame(r - k, c + k, stone)) {
                    break;
                }

                if (k == 4) {
                    if (!isSame(r - 5, c + 5, stone)) {
                        print(r, c, stone);
                    }
                }
            }
        }

        // 우측 하단 대각선
        if (!isSame(r - 1, c - 1, stone)) {
            for (int k = 0; k < 5; k++) {
                if (!isSame(r + k, c + k, stone)) {
                    break;
                }

                if (k == 4) {
                    if (!isSame(r + 5, c + 5, stone)) {
                        print(r, c, stone);
                    }
                }
            }
        }
    }

    private static void print(int r, int c, int stone) {
        System.out.println(stone);
        System.out.println((r + 1) + " " + (c + 1));
        System.exit(0);
    }

    private static boolean isSame(int r, int c, int stone) {
        if (r >= 0 && r < 19 && c >= 0 && c < 19 && go[r][c] == stone) return true;

        return false;
    }
}
