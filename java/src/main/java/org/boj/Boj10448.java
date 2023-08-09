package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj10448 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static int max = 0;
    static List<Integer> triangles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        int cache = 1;
        triangles.add(1);
        for (int i = 0; max > cache; i++) {
            int value = cache + i + 2;
            triangles.add(value);
            cache = triangles.get(i + 1);
        }

        int size = triangles.size();

        ptr : for (int a = 0; a < nums.length; a++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (nums[a] == triangles.get(i) + triangles.get(j) + triangles.get(k)) {
                            System.out.println(1);
                            continue ptr;
                        }
                    }
                }
            }

            System.out.println(0);
        }
    }
}
