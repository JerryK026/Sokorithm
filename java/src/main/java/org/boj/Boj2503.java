package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 1. 123 ~ 987까지 돌면서, 반복되는 수가 있다면 continue한다
* 2. i와 plays[i]를 놓고, strikes 수가 같은지 확인한다
* 3. i와 plays[i]를 놓고, balls 수가 같은지 확인한다
* 4. 모두 통과하면 cnt++;
* */
public class Boj2503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int cnt = 0;
    static int[] plays;
    static int[] strikes;
    static int[] balls;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        plays = new int[N];
        strikes = new int[N];
        balls = new int[N];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            plays[i] = input[0];
            strikes[i] = input[1];
            balls[i] = input[2];

            if (strikes[i] == 3) {
                System.out.println(1);
                System.exit(0);
            }
        }

        l : for (int i = 123; i <= 987; i++) {
            int iFirst = i / 100;
            int iSecond = (i / 10) - (iFirst * 10);
            int iThird = i - (iFirst * 100) - (iSecond * 10);

            if (iFirst == iSecond || iFirst == iThird || iSecond == iThird || iFirst == 0 || iSecond == 0 || iThird == 0) {
                continue;
            }

            for (int j = 0; j < N; j++) {
                int first = plays[j] / 100;
                int second = (plays[j] / 10) - (first * 10);
                int third = plays[j] - (first * 100) - (second * 10);

                if (sameThenPlus(first, iFirst) + sameThenPlus(second, iSecond) + sameThenPlus(third, iThird) != strikes[j]) {
                    continue l;
                }

                if (ballThenPlus(iFirst, second, third) + ballThenPlus(iSecond, first, third) + ballThenPlus(iThird, first, second) != balls[j]) {
                    continue l;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    static int sameThenPlus(int a, int b) {
        return a == b ? 1 : 0;
    }

    static int ballThenPlus(int a, int b, int c) {
        if (a == b || a == c) return 1;

        return 0;
    }
}
