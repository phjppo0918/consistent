package graph.bj1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int parent[];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        Queue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(node1, node2, value));
        }

        parent = new int[nodeSize + 1];
        for (int i = 1; i <=nodeSize; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        int answer = 0;
        while (edgeCount < nodeSize - 1) {
            Edge now = edges.poll();
            if(isSameParent(now.node1, now.node2)) {
                continue;
            }
            answer += now.value;
            edgeCount++;
            union(now.node1, now.node2);
        }

        result.append(answer);
        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static void union(int node1, int node2) {
        parent[getParent(node2)] = getParent(node1);
    }

    public static int getParent(int node) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = getParent(parent[node]);
    }

    public static boolean isSameParent(int node1, int node2) {
        return getParent(node1) == getParent(node2);
    }
}

class Edge implements Comparable<Edge> {
    int node1;
    int node2;
    int value;

    public Edge(int node1, int node2, int value) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
