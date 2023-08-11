package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Element 객체는 List로 연결된 요소를 가진다
 * 2. 각 정점에 대해 Element를 만들어 Map<value, Element>로 관리한다
 * 3. visited = new HashMap<value, Boolean>를 만들어 bfs로 찾아가며 하나라도 linked element가 있다면 cnt++한다
 */
public class Boj11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Map<Integer, Element> elements = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();
    static int cnt;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) {
            elements.put(i, new Element(i));
            visited.put(i, false);
        }

        for (int i = 0; i < M; i++) {
            String[] cur = br.readLine().split(" ");

            int curN = Integer.parseInt(cur[0]);
            int curM = Integer.parseInt(cur[1]);

            Element eN = get(curN);
            Element eM = get(curM);

            eN.linkedElements.add(eM);
            eM.linkedElements.add(eN);
        }

        for (Integer val : elements.keySet()) {
            Element element = get(val);
            if (!isVisited(element)) {
                visited.put(element.value, true);
                search(element);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void search(Element element) {
        for (Element cur : element.linkedElements) {
            if (!isVisited(cur)) {
                visited.put(cur.value, true);
                search(cur);
            }
        }
    }

    static boolean isVisited(Element element) {
        return visited.get(element.value);
    }

    static Element get(int val) {
        if (elements.containsKey(val)) {
            return elements.get(val);
        }

        Element element = new Element(val);
        elements.put(val, element);
        visited.put(val, false);
        return element;
    }

    static class Element {
        List<Element> linkedElements = new ArrayList<>();
        int value;

        Element(int value) {
            this.value = value;
        }
    }
}
