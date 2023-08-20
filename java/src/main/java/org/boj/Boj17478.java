package org.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String msg1 = "\"재귀함수가 뭔가요?\"";
    static String msg2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String msg3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String msg4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String msg5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String msg6 = "라고 답변하였지.";
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0, N);
    }

    static void recur(int i, int N) {
        System.out.println("_".repeat(4 * i) + msg1);

        if (i != N) {
            System.out.println("_".repeat(4 * i) + msg2);
            System.out.println("_".repeat(4 * i) + msg3);
            System.out.println("_".repeat(4 * i) + msg4);
            recur(i + 1, N);
        } else {
            System.out.println("_".repeat(4 * i) + msg5);
        }
        System.out.println("_".repeat(4 * i) + msg6);
    }
}