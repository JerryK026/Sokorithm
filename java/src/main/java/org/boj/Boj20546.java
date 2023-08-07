package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BNP
 * 살 수 있으면 전량 매도
 *
 * 타이밍
 * 3일 연속 주가 상승시 전량 매도
 * 3일 연속 주가 하락시 전량 매수
 */
public class Boj20546 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int bnpMoney;
    static int timMoney;
    static int bnpStock;
    static int timStock;
    static int cache = -1;
    static int increaseCnt = 0;
    static int decreaseCnt = 0;

    public static void main(String[] args) throws IOException {
        int money = Integer.parseInt(br.readLine());
        bnpMoney = money;
        timMoney = money;

        int[] prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int size = prices.length;
        for (int i = 0; i < size; i++) {
            int price = prices[i];
            if (bnpMoney >= price) {
                int count = bnpMoney / price;
                bnpStock += count;
                bnpMoney -= price * count;
            }

            if (cache == -1) {}

            else if (cache < price) {
                increaseCnt++;
                decreaseCnt = 0;
            }

            else if (cache > price) {
                decreaseCnt++;
                increaseCnt = 0;
            }

            else {
                increaseCnt = 0;
                decreaseCnt = 0;
            }

            if (increaseCnt > 2) {
                timMoney += timStock * price;
                timStock = 0;
            }

            if (decreaseCnt > 2 && timMoney >= price) {
                int count = timMoney / price;
                timStock += count;
                timMoney -= price * count;
            }

            cache = price;
        }

        int price = prices[prices.length - 1];
        bnpMoney += bnpStock * price;
        timMoney += timStock * price;

        System.out.println(result());
    }

    static String result() {
        if (bnpMoney > timMoney) {
            return "BNP";
        }

        if (bnpMoney == timMoney) {
            return "SAMESAME";
        }

        return "TIMING";
    }
}
