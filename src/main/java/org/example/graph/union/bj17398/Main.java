package org.example.graph.union.bj17398;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] parents;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int topSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int actSize = Integer.parseInt(st.nextToken());
        graph = new List[topSize + 1];
        parents = new int[topSize + 1];
        count = new int[topSize + 1];
        visited = new boolean[topSize + 1];

        for (int i = 0; i < topSize + 1; i++) {
            parents[i] = i;
        }
        for (int i = 0; i <= topSize; i++) {
            graph[i] = new ArrayList<>();
        }
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            lines.add(new Line(node1, node2));
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        long cost = 0;
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < actSize; i++) {
            int target = Integer.parseInt(br.readLine());
            targets.add(target - 1);
            Line line = lines.get(target - 1);
            graph[line.node1].remove(line.node2);
            graph[line.node2].remove(line.node1);
        }

        for (int i = 1; i < topSize + 1; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int nodeCount = 1;
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer now = queue.poll();
                    for (Integer e : graph[now]) {
                        if (!visited[e]) {
                            nodeCount++;
                            visited[e] = true;
                            parents[e] = i;
                            queue.add(e);
                        }
                    }
                }
                count[i] = nodeCount;
            }
        }

        for (int i = actSize - 1; i >= 0; i--) {
            Line line = lines.get(targets.get(i));
            int parent1 = getParent(line.node1);
            int parent2 = getParent(line.node2);
            if (parent1 == parent2) {
                continue;
            }
            cost += ((long) count[parent1] * count[parent2]);
            count[parent1] += count[parents[parent2]];

            parents[parent2] = parent1;
            parents[line.node2] = parent1;
        }

        sb.append(cost);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int getParent(int node) {
        while (node != parents[node]) {
            node = parents[node];
        }
        return node;
    }
}

class Line {
    Integer node1;
    Integer node2;

    public Line(Integer node1, Integer node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}