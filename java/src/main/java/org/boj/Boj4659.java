package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Boj4659 {
    public static void main(String[] args) throws IOException {
        List<Character> consonants = List.of(new Character[]{'a', 'e', 'i', 'o', 'u'});
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("end")) {
            char cache = input.charAt(0);
            int n = input.length();
            boolean containsConsonants = false;
            boolean isSeparated = true;
            boolean isDifferent = true;

            int cnt = 1;
            if (consonants.contains(cache)) {
                containsConsonants = true;
                cnt = 1;
            }

            for (int i = 1; i < n; i++) {
                char cur = input.charAt(i);

                if (consonants.contains(cur)) {
                    if (consonants.contains(cache)) {
                        cnt++;
                    } else {
                        cnt = 1;
                    }
                    containsConsonants = true;
                } else {
                    if (consonants.contains(cache)) {
                        cnt = 1;
                    } else {
                        cnt++;
                    }
                }

                if (cnt >= 3) {
                    isSeparated = false;
                    break;
                }

                if (cur == cache) {
                    if (!(cur == 'e' || cur == 'o')) {
                        isDifferent = false;
                        break;
                    }
                }

                cache = input.charAt(i);
            }

            if (containsConsonants && isSeparated && isDifferent) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }

            input = br.readLine();
        }
    }
}
