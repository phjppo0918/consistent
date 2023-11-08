package org.example.cbustudy.week4.bj2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        int[] topology = new int[nodeSize + 1];

        List<Integer>[] graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());
            graph[start].add(fin);
            topology[fin]++;
        }
        boolean[] visited = new boolean[topology.length + 1];

        List<Integer> answer = new ArrayList<>();
        while (answer.size() != nodeSize) {
            for (int i = 1; i <= nodeSize; i++) {
                if(!visited[i]&& topology[i] <= 0) {
                    visited[i] = true;
                    answer.add(i);
                    graph[i].forEach(next -> topology[next]--);
                }
            }
        }

        answer.forEach(a -> sb.append(a).append(" "));



        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
