package org.example.graph.union.bi11085;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Road> queue = new PriorityQueue<>();
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        parents = new int[nodeSize + 1];
        for (int i = 0; i < nodeSize + 1; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if(node1 > node2) {
                int temp = node1;
                node1 = node2;
                node2 = temp;
            }
            int value = Integer.parseInt(st.nextToken());

            queue.add(new Road(node1, node2, value));
        }
        int answer = 0;

        while (!queue.isEmpty()) {
            Road road = queue.poll();
            int node1Parent = getParent(road.node1);
            int node2Parent = getParent(road.node2);
            parents[road.node2] = node1Parent;
            parents[node2Parent] = node1Parent;
            if(getParent(start) == getParent(end)) {
                answer = road.value;
                break;
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int getParent(int node) {
        while (node != parents[node]) {
            node = parents[node];
        }

        return node;
    }
}

class Road implements Comparable<Road> {
    int node1;
    int node2;
    int value;

    public Road(int node1, int node2, int value) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }

    @Override
    public int compareTo(Road o) {
        return o.value - value;
    }
}