package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS & BFS 순으로 탐색
// 방문할 수 있는 정점이 여러개라면 번호가 작은 순으로
public class Boj1260 {
    static StringBuilder sb;

    static class Node implements Comparable<Node> {
        int value;
        List<Node> links  = new ArrayList<>();
        boolean visited1 = false;
        boolean visited2 = false;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Node startNode = nodeMap.getOrDefault(start, new Node(start));
            Node endNode = nodeMap.getOrDefault(end, new Node(end));

            startNode.links.add(endNode);
            endNode.links.add(startNode);

            nodeMap.putIfAbsent(start, startNode);
            nodeMap.putIfAbsent(end, endNode);
        }

        // dfs
        Node start = nodeMap.getOrDefault(V, new Node(V));
        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb.toString().trim());

        // bfs
        sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.visited2) continue;

            cur.visited2 = true;
            sb.append(cur.value).append(" ");
            cur.links.stream().forEach(next -> q.add(next));
        }

        System.out.println(sb.toString().trim());
    }

    static void dfs(Node cur) {
        if (cur.visited1) return;

        cur.visited1 = true;
        Collections.sort(cur.links);
        sb.append(cur.value).append(" ");
        cur.links.forEach(next -> dfs(next));
    }
}
