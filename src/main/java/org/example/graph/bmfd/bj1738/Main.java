package org.example.graph.bmfd.bj1738;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static final Long MIN_VALUE = Long.MIN_VALUE + Integer.MAX_VALUE;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int rodeSize = Integer.parseInt(st.nextToken());
        long dis[]  = new long[nodeSize + 1];
        List<Edge>[] graph = new List[rodeSize + 1];
        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= rodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dis, MIN_VALUE);
        for (int i = 0; i < rodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, value));
            graph[start].add(new Edge(start, end, value));
        }
        dis[1] = 0;
        boolean isCycle = false;
        for (int i = 0; i < nodeSize - 1; i++) {
            for (int j = 0; j < rodeSize; j++) {
                Edge now = edges.get(j);
                if(dis[now.end] == MIN_VALUE) {
                    continue;
                }
                dis[now.end] = Math.max(dis[now.end], dis[now.start] + now.value);
            }
        }
        long before = dis[nodeSize];
        for (int i = 0; i < nodeSize - 1; i++) {
            for (int j = 0; j < rodeSize; j++) {
                Edge now = edges.get(j);
                if(dis[now.end] == MIN_VALUE) {
                    continue;
                }
                dis[now.end] = Math.max(dis[now.end], dis[now.start] + now.value);
            }
        }
        if(dis[nodeSize] > before) {
            isCycle = true;
        }

        if(isCycle || dis[nodeSize] == MIN_VALUE) {
            sb.append(-1);
        }else {
            long[] value = new long[nodeSize + 1];
            Queue<Integer> queue = new LinkedList<>();

        }



        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
class Edge {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
