package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        SortedMap<Integer, Integer> db = new TreeMap<>((x, y) -> y.compareTo(x));
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            db.put(input, db.getOrDefault(input, 0) + 1);
        }

        Iterator<Integer> keys = db.keySet().iterator();
        int highest = keys.next();
        int next = 0;
        if (db.size() != 1) {
            next = keys.next();
        }
        int sum = 0;
        int count = db.get(highest);
        for (int i = highest - 1; i >= 0; i--) {
            sum += count;

            if (sum >= M) {
                System.out.println(i);
                System.exit(0);
            }

            if (next == i) {
                count += db.get(next);
//                if (keys.hasNext()) {
                    next = keys.next();
//                }
            }
        }
    }
}
