package org.example.cbustudy.week4.bj18352;

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
        int targetLength = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        int[] minVisit = new int[nodeSize + 1];
        Arrays.fill(minVisit, Integer.MAX_VALUE);
        List<Integer>[] graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        minVisit[startNode] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : graph[now]) {
                if(minVisit[next] > minVisit[now] + 1) {
                    minVisit[next] = minVisit[now] + 1;
                    queue.add(next);
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= nodeSize; i++) {
            if(minVisit[i] == targetLength) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            sb.append(-1);
        }else {
            answer.forEach(i -> sb.append(i).append("\n"));
        }




        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
