package org.example.cbustudy.week4.bj1916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(br.readLine());

        List<Node>[] graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, value));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>();
        int[] max = new int[nodeSize + 1];
        Arrays.fill(max, Integer.MAX_VALUE);
        max[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            final Node now = queue.poll();
            if(now.to == end) {
                break;
            }
            for(Node next : graph[now.to]) {
                final int nextLength = max[now.to] + next.value;
                if(max[next.to] > nextLength) {
                    max[next.to] = nextLength;
                    queue.add(new Node(next.to, nextLength));
                }
            }
        }

        sb.append(max[end]);

        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Node implements Comparable<Node> {
    int to;
    int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
