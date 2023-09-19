package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * - 만앿 쪼개지면 좌우에 ()를 붙인다
 * - 1. 순회 돌면서 전부 1 혹은 0인지 체크
 * - 2. 아니라면 (붙이고 재귀 후 )
 * - 2-1. 맞다면 1 혹은 0
 * - 재귀 돌릴 때는 start / end를 넘긴다
 */
public class Boj1992 {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        compress(0, N, 0, N);
        System.out.println(sb.toString());
    }

    // start : count시 포함, end : count시 미포함
    static void compress(int rStart, int rEnd, int cStart, int cEnd) {
        // 0 : 백, 1 : 흑, 2 : 뒤섞임
        int flag = arr[rStart][cStart];
        iter: for (int i = rStart; i < rEnd; i++) {
            for (int j = cStart; j < cEnd; j++) {
                if (arr[i][j] != flag) {
                    flag = 2;
                    break iter;
                }
            }
        }

        if (flag != 2) {
            sb.append(flag);
            return;
        }

        sb.append("(");
        int rMid = (rStart + rEnd) / 2;
        int cMid = (cStart + cEnd) / 2;
        compress(rStart, rMid, cStart, cMid);
        compress(rStart, rMid, cMid, cEnd);
        compress(rMid, rEnd, cStart, cMid);
        compress(rMid, rEnd, cMid, cEnd);
        sb.append(")");
    }
}
