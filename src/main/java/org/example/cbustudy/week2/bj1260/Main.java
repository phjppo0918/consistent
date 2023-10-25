package org.example.cbustudy.week2.bj1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer> dfsAnswer = new ArrayList<>();
    static List<Integer> bfsAnswer = new ArrayList<>();

    static boolean[] visited;
    static List<Integer>[] graph;
    static int start;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new List[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 0; i <= nodeSize; i++) {
            Collections.sort(graph[i]);
        }

        doDfs();
        Arrays.fill(visited, false);
        doBfs();

        dfsAnswer.forEach(i -> sb.append(i).append(" "));
        sb.append("\n");
        bfsAnswer.forEach(i -> sb.append(i).append(" "));


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static void doDfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.empty()) {
            int now = stack.pop();
            if(visited[now]) {
                continue;
            }
            dfsAnswer.add(now);
            visited[now] = true;
            for (int i = graph[now].size() - 1; i >= 0; i--) {
                int next = graph[now].get(i);
                if(!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

    static void doBfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        bfsAnswer.add(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    bfsAnswer.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
