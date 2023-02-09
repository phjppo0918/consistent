package org.example.graph.bj1766;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] graph;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int qSize = Integer.parseInt(st.nextToken());
        int infoSize = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[qSize+1];
        for (int i = 0; i <= qSize; i++) {
            list.add(new ArrayList<>());
        }
        graph = new int[qSize + 1];
        for (int i = 0; i < infoSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= qSize; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int now = pq.poll();
            for (int i : list.get(now)) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    pq.add(i);
                }
            }
            sb.append(now).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
