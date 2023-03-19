package org.example.graph.bmfd.bj11657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        long[] range = new long[nodeSize + 1];
        Arrays.fill(range, Long.MAX_VALUE);
        range[1] = 0;

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, value));
        }
        for (int i = 0; i < nodeSize - 1; i++) {
            for (int j = 0; j < edgeSize; j++) {
                Edge now = edges.get(j);
                if (range[now.start] == Long.MAX_VALUE) {
                    continue;
                }
                range[now.end] = Math.min(range[now.end], range[now.start] + now.value);
            }
        }
        boolean isCycle = false;
        for (int i = 0; i < nodeSize - 1; i++) {
            for (int j = 0; j < edgeSize; j++) {
                Edge now = edges.get(j);
                if (range[now.start] == Long.MAX_VALUE) {
                    continue;
                }

                if (range[now.end] > range[now.start] + now.value) {
                    isCycle = true;
                    break;
                }
            }
        }
        if(isCycle) {
            sb.append(-1);
        }else {
            for (int i = 2; i <=nodeSize; i++) {
                if(range[i] == Long.MAX_VALUE) {
                    range[i] = -1;
                }
                sb.append(range[i]).append("\n");
            }
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
