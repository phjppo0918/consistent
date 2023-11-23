package org.example.cbustudy.week6.bj1414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] union;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        union = new int[size];
        for (int i = 0; i < size; i++) {
            union[i] = i;
        }

        Queue<Node> queue = new PriorityQueue<>();
        int total = 0;

        for (int i = 0; i < size; i++) {
            final String str = br.readLine();
            for (int j = 0; j < size; j++) {
                final int value = toPoint(str.charAt(j));
                total += value;
                if(i != j && value != 0) {
                    queue.add(new Node(i , j, value));
                }

            }
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            final Node now = queue.poll();

            if(union(now.start) == union(now.end)) {
                continue;
            }

            answer += now.value;
            union[union(now.end)] = union(now.start);
        }

        answer = total - answer;
        for (int i = 1; i < size; i++) {
            if(union(0) != union(i)) {
                answer = -1;
                break;
            }
        }

        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    private static int union(int n) {
        if(union[n] == n) {
            return n;
        }

        union[n] = union(union[n]);
        return union[n];
    }
    private static int toPoint(char c) {
        if(isNum(c)) return c - '0';
        else if(isUpper(c)) return c - 'A' + 27;
        else return c - 'a' + 1;
    }
    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isUnder(char c) {
        return c >= 'a' && c <= 'z';
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int value;

    public Node(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}