package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> values = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        System.out.println(values.size());

        Collections.sort(values);

        for (int value : values) {
            System.out.println(value);
        }
    }

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {-1, 0, 1, 0};
    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        int cnt = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int a = 0; a < 4; a++) {
                int ni = di[a] + p.i;
                int nj = dj[a] + p.j;
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj] && map[ni][nj] == 1) {
                    visited[ni][nj] = true;
                    cnt++;
                    q.add(new Point(ni, nj));
                }
            }
        }

        values.add(cnt);
    }

    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
