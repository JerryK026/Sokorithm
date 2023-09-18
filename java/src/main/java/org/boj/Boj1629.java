package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 필요한 건 나머지
public class Boj1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 밑
        long A = Long.parseLong(st.nextToken());
        // 지수
        long B = Long.parseLong(st.nextToken());
        // 몫
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long base, long exponent, long share) {
        if (exponent == 1) {
            return base % share;
        }

        long temp = pow(base, exponent / 2, share);

        if (exponent % 2 == 1) {
            return (temp * temp % share) * base % share;
        }

        return temp * temp % share;
    }
}
