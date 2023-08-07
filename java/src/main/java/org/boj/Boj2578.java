package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1 ~ 5줄까지 빙고판을 채운다
// 6 ~ 10줄까지 가회자가 수를 부른다
// 가로 / 세로 / 대각선 중 모두 채워진 부분이 있으면 줄을 긋는다
// 줄을 그은 횟수가 3개 이상 그어지면 빙고를 외친다
// 빙고를 몇번째 턴에 외치는지 출력한다

public class Boj2578 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] bingo = new boolean[5][5];
    static Map<Integer, Integer> board = new HashMap<>();
    static int[][] answer = new int[5][];
    static int crossCount = 0;
    static boolean leftFlag = false;
    static boolean rightFlag = false;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board.put(Integer.parseInt(str[j]), (i * 5) + j + 1);
            }
        }

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            answer[i] = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0 ; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int ans = answer[i][j];
                if (check(board.get(ans) - 1)) {
                    System.out.println((i * 5) + (j + 1));
                    return;
                }
            }
        }
    }

    private static boolean check(int index) {
        int x = index / 5;
        int y = index % 5;
        bingo[x][y] = true;
        isRowCrossed(x);
        isColumnCrossed(y);
        isLeftCrossCrossed();
        isRightCrossCrossed();

        if (crossCount >= 3) {
            return true;
        }

        return false;
    }

    private static boolean isRowCrossed(int x) {
        for (int i = 0; i < 5; i++) {
            if (!bingo[x][i]) {
                return false;
            }
        }

        addCrossCount();
        return true;
    }

    private static boolean isColumnCrossed(int y) {
        for (int i = 0; i < 5; i++) {
            if (!bingo[i][y]) {
                return false;
            }
        }

        addCrossCount();
        return true;
    }

    private static boolean isLeftCrossCrossed() {
        if (leftFlag) {
            return false;
        }

        for (int i = 0; i < 5; i++) {
            if (!bingo[i][i]) {
                return false;
            }
        }

        addCrossCount();
        leftFlag = true;
        return true;
    }

    private static boolean isRightCrossCrossed() {
        if (rightFlag) {
            return false;
        }

        for (int i = 4; i >= 0; i--) {
            if (!bingo[i][4 - i]) {
                return false;
            }
        }

        addCrossCount();
        rightFlag = true;
        return true;
    }
    
    private static void addCrossCount() {
        crossCount++;
    }
}