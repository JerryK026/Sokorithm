package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {-1, 0, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int size = N - 1;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                for (int k = 1; k < size; k++) {
                    for (int l = 1; l < size; l++) {
                        for (int m = 1; m < size; m++) {
                            for (int n = 1; n < size; n++) {
                                min = Math.min(calculate(i, j, k, l, m , n), min);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }

    static int calculate(int i, int j, int k, int l, int m, int n) {
        int amount = 0;
        boolean[][] visited = new boolean[N][N];
        for (int a = 0; a < 5; a++) {
            int di = i + dr[a];
            int dj = j + dc[a];
            int dk = k + dr[a];
            int dl = l + dc[a];
            int dm = m + dr[a];
            int dn = n + dc[a];

            if (!visited[di][dj]) {
                visited[di][dj] = true;
                amount += map[di][dj];
            } else return Integer.MAX_VALUE;

            if (!visited[dk][dl]) {
                visited[dk][dl] = true;
                amount += map[dk][dl];
            } else return Integer.MAX_VALUE;

            if (!visited[dm][dn]) {
                visited[dm][dn] = true;
                amount += map[dm][dn];
            } else return Integer.MAX_VALUE;
        }

        return amount;
    }
}
