package org.boj;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String>[] inputs = new TreeSet[51];
        for (int i = 1; i <= 50; i++) {
            inputs[i] = new TreeSet<>();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            inputs[input.length()].add(input);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 50; i++) {
            Set<String> inputList = inputs[i];
            for (String input : inputList) {
                sb.append(input).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
