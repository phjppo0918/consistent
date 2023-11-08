package org.example.cbustudy.week4.bj1516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int[] cost = new int[citySize + 1];

        List<Integer>[] graph = new List[citySize + 1];
        int[] poly = new int[citySize + 1];
        for (int i = 0; i <= citySize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= citySize; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                graph[next].add(i);
                poly[i]++;
                next = Integer.parseInt(st.nextToken());
            }
        }

        int answerCount = 0;
        boolean[] visited = new boolean[citySize + 1];
        int[] totalCost = new int[citySize + 1];

        while (answerCount < citySize) {
            for (int i = 1; i <= citySize; i++) {
                if (!visited[i] && poly[i] <= 0) {
                    visited[i] = true;
                    answerCount++;
                    for (int next : graph[i]) {
                        poly[next]--;
                        totalCost[next] = Math.max(totalCost[next], totalCost[i] + cost[i]);
                    }
                }
            }
        }

        for (int i = 1; i <= citySize; i++) {
            sb.append(cost[i] +totalCost[i]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
