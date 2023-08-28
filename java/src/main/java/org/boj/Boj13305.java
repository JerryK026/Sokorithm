package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj13305 {
    /**
     * long으로 합쳐야 함
     * 현재에선 다음 도시들중 현재 도시보다 싼 도시가 나올 때까지 더하면 어떨까?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distances = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] inputPrices = br.readLine().split(" ");
        long cachePrice = Integer.parseInt(inputPrices[0]);
        long cacheDistanceSum = distances[0];
        long priceSum = 0;
        for (int i = 1; i < N - 1; i++) {
            int price = Integer.parseInt(inputPrices[i]);

            if (cachePrice > price) {
                priceSum += cacheDistanceSum * cachePrice;
                cachePrice = price;
                cacheDistanceSum = 0;
            }

            cacheDistanceSum += distances[i];
        }

        priceSum += cacheDistanceSum * cachePrice;

        System.out.println(priceSum);
    }
}
