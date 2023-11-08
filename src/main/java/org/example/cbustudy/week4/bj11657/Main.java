package org.example.cbustudy.week4.bj11657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        Node[] graph = new Node[edgeSize +1];

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[i] = new Node(start, end, v);
        }

        long[] value = new long[nodeSize + 1];
        Arrays.fill(value, Long.MAX_VALUE);
        value[1] = 0;

        for (int i = 0; i < nodeSize; i++) {
            for (int j = 0; j < edgeSize; j++) {
                Node now = graph[j];
                if(value[now.start] != Long.MAX_VALUE && value[now.end] > value[now.start] + now.value) {
                    value[now.end] = value[now.start] + now.value;
                }
            }
        }


        boolean isInfinite = false;

        for (int j = 0; j < edgeSize; j++) {
            Node now = graph[j];
            if(value[now.start] != Long.MAX_VALUE && value[now.end] > value[now.start] + now.value) {
                isInfinite = true;
                break;
            }
        }
        if(isInfinite)  {
            sb.append(-1);
        }else {
            for (int i = 2; i <= nodeSize; i++) {
                if(value[i] == Long.MAX_VALUE) {
                    sb.append(-1);
                }else {
                    sb.append(value[i]);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int start;
    int end;
    long value;

    public Node(int start, int end, long value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
