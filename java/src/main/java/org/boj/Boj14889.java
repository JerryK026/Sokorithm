package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N*N 크기의 배열을 만든다
 * 팀 조합 경우의 수를 모두 만든다
 * 점수를 매긴다
 *
 */
public class Boj14889 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] team;
    static boolean[] visit;
    static int N, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        team = new int[N][];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            team[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        combination(0, 0);

        System.out.println(min);
    }

    static void combination(int i, int depth) {
        if (depth * 2 == N) {
            diff();
            return;
        }

        for (int j = i; j < N; j++) {
            if (!visit[j]) {
                visit[j] = true;
                combination(j + 1, depth + 1);
                visit[j] = false;
            }
        }
    }

    static void diff() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += team[i][j] + team[j][i];
                }

                else if (visit[i] == false && visit[j] == false) {
                    link += team[i][j] + team[j][i];
                }
            }
        }

        if (start == link) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(Math.abs(start - link), min);
    }
}
