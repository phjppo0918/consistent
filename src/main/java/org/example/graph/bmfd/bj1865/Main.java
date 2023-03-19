package org.example.graph.bmfd.bj1865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final String NO = "NO";
    private static final String YES = "YES";
    private static final Long MAX_VALUE = Long.MAX_VALUE - Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int roadSize = Integer.parseInt(st.nextToken());
            int holeSize = Integer.parseInt(st.nextToken());

            List<Edge>[] edges = new List[nodeSize + 1];
            for (int i = 1; i <= nodeSize; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < roadSize; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                edges[start].add(new Edge(end, value));
                edges[end].add(new Edge(start, value));
            }
            for (int i = 0; i < holeSize; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                edges[start].add(new Edge(end, -value));
            }
            boolean isCycle = bellmanFord(edges);

            if (isCycle) {
                sb.append(YES).append("\n");
            } else {
                sb.append(NO).append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean bellmanFord(List<Edge>[] edges) {
        int nodeSize = edges.length - 1;
        long[] dis = new long[nodeSize + 1];
        Arrays.fill(dis, MAX_VALUE);


        for (int i = 1; i <= nodeSize ; i++) {
            for (int j = 1; j < edges.length; j++) {
                for(Edge e : edges[j]) {
//                    if(dis[j] == MAX_VALUE) {
//                        continue;
//                    }
                    dis[j] = Math.min(dis[j], dis[e.end] + e.value);
                }
            }
        }

        for (int i = 1; i <= nodeSize ; i++) {
            for (int j = 1; j < edges.length; j++) {
                for(Edge e : edges[j]) {
//                    if(dis[j] == MAX_VALUE) {
//                        continue;
//                    }
                    if(dis[j] > dis[e.end] + e.value) {
                        return true;
                    }
                }
            }
        }
        return false;
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
