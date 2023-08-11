package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. N을 입력받는다
 * 2. 수를 입력하며 최대값 max을 구한다
 * 3. 0부터 max까지 반복문을 돌며 max이하의 수를 가진 칸은 false 처리한다
 * 4. true일 경우 주위를 돌며 mapValue <= i && visited==false인 경우 bfs를 돌며 visited==true로 만든다
 * 5. bfs를 한 번이라도 탔다면 cnt++한다
 */
public class Boj2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    static int maxCnt = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(input[j]);
                map[i][j] = cur;
                max = Math.max(max, cur);
            }
        }

        for (int i = 0; i < max; i++) {
            visited = new boolean[N][N];
            bfs(i);
        }

        System.out.println(maxCnt);
    }

    static void bfs(int depth) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > depth && !visited[i][j]) {
                    search(i, j, depth);
                    cnt++;
                }
            }
        }

        maxCnt = Math.max(maxCnt, cnt);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void search(int x, int y, int depth) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > depth) {
                search(nx, ny, depth);
            }
        }
    }
}
