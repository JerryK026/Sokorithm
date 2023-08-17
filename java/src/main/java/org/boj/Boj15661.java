package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15661 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] S;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        S = new int[N][];
        boolean[] team = new boolean[N];

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, team);

        System.out.println(min);
    }

    static void dfs(int n, boolean[] team) {
        if (n == N) {
            int startSum = 0;
            int linkSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (team[i] == team[j] && team[i] == false) {
                        startSum += S[i][j];
                    }

                    else if (team[i] == team[j] && team[i] == true) {
                        linkSum += S[i][j];
                    }
                }
            }

            min = Math.min(Math.abs(startSum - linkSum), min);

            return;
        }
        boolean[] newTeam = new boolean[N];
        System.arraycopy(team, 0, newTeam, 0, team.length);
        team[n] = true;
        dfs(n + 1, team);
        dfs(n + 1, newTeam);
    }
}
