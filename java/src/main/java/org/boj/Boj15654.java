package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj15654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] input;
    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        dfs(new ArrayList<>(), new boolean[N]);
    }

    static void dfs(List<Integer> numbers, boolean[] visited) {
        if (numbers.size() == M) {
            System.out.println(numbers.stream().map(it -> it.toString()).collect(Collectors.joining(" ")));
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Integer> numbersCopy = new ArrayList<>(numbers);
                boolean[] visitedCopy = new boolean[N];
                System.arraycopy(visited, 0, visitedCopy, 0, N);
                numbersCopy.add(input[i]);
                visitedCopy[i] = true;
                dfs(numbersCopy, visitedCopy);
            }
        }
    }
}
