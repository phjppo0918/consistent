package org.example.graph.destra.bj10282;

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

        int testSize = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testSize; t++) {
            st = new StringTokenizer(br.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            List<Edge>[] graph = new List[nodeSize + 1];
            long[] values = new long[nodeSize + 1];
            for (int i = 1; i <= nodeSize; i++) {
                graph[i] = new ArrayList<>();
            }
            Arrays.fill(values, Long.MAX_VALUE);
            values[startNode] = 0;
            for (int i = 0; i < edgeSize; i++) {
                st = new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                graph[start].add(new Edge(end, value));
            }

            Queue<Cost> queue = new PriorityQueue<>();
            queue.add(new Cost(startNode, 0));

            while (!queue.isEmpty()) {
                Cost now = queue.poll();
                for(Edge e : graph[now.node]) {
                    if(values[e.end] > values[now.node] + e.value) {
                        values[e.end] = values[now.node] + e.value;
                        queue.add(new Cost(e.end, values[e.end]));
                    }
                }
            }

            long count = 0;
            long max = 0;

            for (int i = 1; i <= nodeSize; i++) {
                if(values[i] != Long.MAX_VALUE) {
                    count++;
                    max = Math.max(max, values[i]);
                }
            }
            sb.append(count).append(' ').append(max).append('\n');


        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
class Cost implements Comparable<Cost> {
    int node;
    long value;

    public Cost(int node, long value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Cost o) {
        return (int)(value - o.value);
    }
}

class Edge {
    int end;
    int value;

    public Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
}
