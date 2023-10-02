package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);

        int[][] box = new int[n][m];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new Point(i, j, 0));
                }
            }
        }

        int max = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && box[nr][nc] == 0) {
                    box[nr][nc] = 1;
                    q.add(new Point(nr, nc, point.days + 1));
                    max = point.days + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(max);
    }

    private static class Point {
        int r;
        int c;
        int days;

        public Point(int r, int c, int days) {
            this.r = r;
            this.c = c;
            this.days = days;
        }
    }
}
