package org.example.dbn.bj17073;

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
        int water = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeSize-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        boolean[] visited = new boolean[nodeSize + 1];
        int leafCount = 0;
        double total = 0;
        double[] waters = new double[nodeSize + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        waters[1] = water;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            double div = waters[now]/graph[now].size();
            boolean isLeaf = true;
            for(Integer next : graph[now]) {
                if(!visited[next]) {
                    isLeaf = false;
                    queue.add(next);
                    graph[next].remove(now);
                    visited[next] = true;
                }
                waters[next] += div;
            }
            if(isLeaf) {
                total+= waters[now];
                leafCount++;
            }
        }

        sb.append(total/leafCount);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
