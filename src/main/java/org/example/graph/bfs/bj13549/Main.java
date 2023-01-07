package org.example.graph.bfs.bj13549;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static final List<Node>[] graph = new List[100_001];
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
        bfs(start, finish);
        result.append(visitCount[finish]);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    private static void createGraph() {
        for (int i = 0; i <=100_000; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Node(1, 1));
        graph[1].add(new Node(0, 1));
        for (int i = 1; i <= 50_000; i++) {
            graph[i].add(new Node(i * 2, 0));
            graph[i].add(new Node(i+1, 1));
            graph[i+1].add(new Node(i, 1));
            //graph[i*2].add(i);
        }
        for (int i = 50_001; i < 100_000; i++) {
            graph[i].add(new Node(i+1, 1));
            graph[i+1].add(new Node(i, 1));
        }
    }
    private static void bfs(int start, int finish) {
        isVisit[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(now == finish) {
                break;
            }
            for(Node n : graph[now]) {
                if(!isVisit[n.end]) {
                    visitCount[n.end] = visitCount[now] + n.v;
                    isVisit[n.end] = true;
                    queue.add(n.end);
                }
            }
        }
    }
}
class Node {
    int end;
    int v;

    public Node(int end, int v) {
        this.end = end;
        this.v = v;
    }
}


