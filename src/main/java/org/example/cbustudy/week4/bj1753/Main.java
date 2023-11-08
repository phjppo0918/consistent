package org.example.cbustudy.week4.bj1753;

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
        int edgeSize = Integer.parseInt(st.nextToken());
        final int start = Integer.parseInt(br.readLine());

        List<Node>[] graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, v));
        }

        int[] max = new int [nodeSize + 1];
        Arrays.fill(max, Integer.MAX_VALUE);

        max[start] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            final Node now = queue.poll();
            for(Node next : graph[now.to]) {
                int nextLength = next.value + max[now.to];
                if(max[next.to] > nextLength) {
                    max[next.to] = nextLength;
                    queue.add(new Node(next.to, nextLength));
                }
            }
        }

        for (int i = 1; i <=nodeSize ; i++) {
            if(max[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }else {
                sb.append(max[i]);
            }
            sb.append("\n");
        }




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
