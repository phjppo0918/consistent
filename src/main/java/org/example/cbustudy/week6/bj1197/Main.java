package org.example.cbustudy.week6.bj1197;

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

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>();
        union = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            union[i] = i;
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            int v = Integer.parseInt(st.nextToken());
            queue.add(new Node(n1, n2, v));
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
}

class Node implements Comparable<Node> {
    int start;
    int end;
    long value;

    public Node(int start, int end, long value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return  (int)(value- o.value);
    }
}