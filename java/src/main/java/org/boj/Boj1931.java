package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj1931 {
    static class Node implements Comparable<Node> {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end < o.end) {
                return -1;
            }

            if (this.end > o.end) {
                return 1;
            }

            if (this.start < o.start) {
                return -1;
            }

            if (this.start > o.start) {
                return 1;
            }

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> nodes = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            nodes.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(nodes);

        int cachedEnd = 0;
        int cnt = 0;
        for (Node node : nodes) {
            if (cachedEnd <= node.start) {
                cnt++;
                cachedEnd = node.end;
            }
        }
        System.out.println(cnt);
    }
}
