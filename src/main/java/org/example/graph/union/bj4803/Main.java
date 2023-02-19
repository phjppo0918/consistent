package org.example.graph.union.bj4803;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static final String NO_TREE_VIEW = "No trees.";
    private static final String ONE_TREE_VIEW = "There is one tree.";
    private static boolean[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int caseCount = 1;

        while (nodeCount != 0 || edgeCount != 0) {
            graph = new boolean[nodeCount + 1][nodeCount + 1];
            visited = new boolean[nodeCount + 1];
            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                graph[node1][node2] = true;
                graph[node2][node1] = true;
            }
            int treeCount = 0;
            for (int i = 1; i <= nodeCount; i++) {
                Queue<Integer> queue = new LinkedList<>();
                for (int j = 1; j <= nodeCount; j++) {
                    if(graph[i][j]) {
                        queue.add(i);
                        visited[i] = true;
                        boolean isTree = true;
                        while (!queue.isEmpty()) {
                            int now = queue.poll();
                            for (int k = 1; k <= nodeCount; k++) {
                                if(graph[now][k]) {
                                    if(visited[k]) {
                                        isTree = false;
                                    }else {
                                        visited[k] = true;
                                        graph[k][now] = false;
                                        queue.add(k);
                                    }
                                }
                            }
                        }
                        if(isTree) {
                            treeCount++;
                        }
                        break;
                    }
                }
            }
            for (int i = 1; i <= nodeCount; i++) {
                if(!visited[i]) {
                    treeCount++;
                }
            }
            sb.append(toCaseView(caseCount));
            if(treeCount == 0) {
                sb.append(NO_TREE_VIEW).append("\n");
            }else if (treeCount == 1) {
                sb.append(ONE_TREE_VIEW).append("\n");
            }else {
                sb.append(toForestView(treeCount)).append("\n");
            }

            caseCount++;
            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            edgeCount = Integer.parseInt(st.nextToken());
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static String toCaseView(int count) {
        return "Case " + count + ": ";
    }

    private static String toForestView(int count) {
        return "A forest of " + count + " trees.";
    }
}