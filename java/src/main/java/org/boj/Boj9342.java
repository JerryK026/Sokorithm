package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

// 첫글자는 A, B, C, D, E, F가 될 수도 있다
// 뭉치1은 A의 연속이다 (1개 이상)
// 뭉치2는 F의 연속이다 (1개 이상)
// 뭉치3은 C의 연속이다 (1개 이상)
// 마지막 글자는 A, B, C, D, E, F가 될 수도 있다
public class Boj9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        List<Character> targets = Arrays.asList(new Character[]{'A', 'B', 'C', 'D', 'E', 'F'});
        str: for (int i = 0; i < T; i++) {
            String input = br.readLine();

            boolean aFlag = false, fFlag = false, cFlag = false;
            int j = 0;
            if (!targets.contains(input.charAt(j))) {
                sb.append("Good").append("\n");
                continue;
            } else {
                if (input.charAt(j) != 'A') {
                    j++;
                    if (j >= input.length() - 1) {
                        sb.append("Good").append("\n");
                        continue;
                    }
                }
                aFlag = true;
            }

            while (input.charAt(j) == 'A') {
                j++;
                aFlag = true;
                if (j >= input.length()) {
                    sb.append("Good").append("\n");
                    continue str;
                }
            }

            while (input.charAt(j) == 'F') {
                j++;
                fFlag = true;
                if (j >= input.length()) {
                    sb.append("Good").append("\n");
                    continue str;
                }
            }

            while (input.charAt(j) == 'C') {
                j++;
                cFlag = true;
                if (j >= input.length() - 1) {
                    break;
                }
            }

            if (aFlag && fFlag && cFlag) {
                if (j == input.length()) {
                    sb.append("Infected!").append("\n");
                    continue;
                }

                else if (j == input.length() - 1 && targets.contains(input.charAt(j))) {
                    sb.append("Infected!").append("\n");
                    continue;
                }
            }

            sb.append("Good").append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
