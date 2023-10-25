package org.example.cbustudy.week2.bj13023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean answer = false;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        graph = new List[nodeSize];
        visited = new boolean[nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 0; i < nodeSize; i++) {

            backtracking(i, 1);
            if (answer) {
                break;
            }
        }
        if (answer) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int node, int depth) {
        if (depth == 5) {
            answer = true;
            return;
        }

        visited[node] = true;
        for(int next: graph[node]) {
            if(!visited[next]) {
                backtracking(next, depth + 1);
            }
        }
        visited[node] = false;
    }
}
