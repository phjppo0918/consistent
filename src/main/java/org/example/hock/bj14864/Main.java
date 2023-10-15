package org.example.hock.bj14864;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean cant = false;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentCount = Integer.parseInt(st.nextToken());
        int pairCount = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[studentCount];
        for (int i = 0; i < studentCount; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            nodes[num1 - 1].value++;
            nodes[num2 - 1].value--;
        }
        Arrays.sort(nodes);
        int[] answer = new int[studentCount + 1];
        boolean isNo = false;
        answer[nodes[0].index] = 1;
        for (int i = 1; i < studentCount; i++) {
            answer[nodes[i].index] = i+1;
            if(nodes[i].value == nodes[i-1].value) {
                isNo = true;
                break;
            }
        }

        if(!isNo) {
            sb.append(-1);
        }else {
            for (int i = 1; i <= studentCount; i++) {
                sb.append(answer[i]).append(" ");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int index;
        int value = 0;

        public Node(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}


