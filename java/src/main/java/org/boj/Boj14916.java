package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj14916 {
    // 2  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  ... 가능
    // 10 20 01 30 11 40 21 02  31  12  41  22  03
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 1 || n == 3) {
            System.out.println(-1);
            System.exit(0);
        }

        if (n % 5 == 0) {
            System.out.println(n / 5);
            System.exit(0);
        }

        for (int i = n / 5; i < n; i--) {
            int tmp = n;
            tmp -= i * 5;
            if (tmp % 2 == 0) {
                System.out.println(i + (tmp / 2));
                break;
            }
        }
    }
}
