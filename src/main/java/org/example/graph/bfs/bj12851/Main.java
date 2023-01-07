package org.example.graph.bfs.bj12851;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static final List<Integer>[] graph = new List[100_001];
    private static int[] visitCount = new int[100_001];
    private static boolean[] isVisit = new boolean[100_001];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        createGraph();
        int answer = bfs(start, finish);
        if (start == finish) {
            answer++;
        }
        result.append(visitCount[finish]).append("\n").append(answer);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void createGraph() {
        for (int i = 0; i <=100_000; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(0);
        for (int i = 1; i <= 50_000; i++) {
            graph[i].add(i+1);
            graph[i+1].add(i);
            graph[i].add(i*2);
            //graph[i*2].add(i);
        }
        for (int i = 50_001; i < 100_000; i++) {
            graph[i].add(i+1);
            graph[i+1].add(i);
        }
    }
    public static int bfs(int start, int finish) {
        isVisit[start] = true;
        int answerCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(now == finish) {
                break;
            }
            for(Integer i : graph[now]) {
                if(!isVisit[i] || visitCount[now] + 1 <= visitCount[i]) {
                    if(i == finish) {
                       answerCount++;
                    }
                    visitCount[i] = visitCount[now] + 1;
                    isVisit[i] = true;
                    queue.add(i);
                }
            }
        }

        return answerCount;
    }
}
