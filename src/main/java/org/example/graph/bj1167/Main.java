package graph.bj1167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int[] rangeTotal;
    public static boolean[] visited;
    public static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        rangeTotal = new int[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        edges = new List[nodeSize + 1];
        IntStream.range(1, nodeSize + 1).forEach(
                i -> edges[i] = new ArrayList<>()
        );

        for (int i = 1; i <= nodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int num1 = Integer.parseInt(st.nextToken());
                if (num1 == -1) {
                    break;
                }

                int num2 = Integer.parseInt(st.nextToken());

                Edge edge = new Edge(num1, num2);
                edges[node].add(edge);
            }
        }

        bfs(1);

        int maxPivot = 1;
        for (int i = 1; i <= nodeSize; i++) {
            if (rangeTotal[i] > rangeTotal[maxPivot]) {
                maxPivot = i;
            }
        }

        rangeTotal = new int[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        bfs(maxPivot);
        result.append(Arrays.stream(rangeTotal).max().orElseGet(() -> 0));


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge i : edges[now]) {
                int e = i.node;
                int v = i.edgeValue;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    rangeTotal[e] = rangeTotal[now] + v;
                }
            }
        }

    }
}

class Edge {
    int node;
    int edgeValue;

    public Edge(int node, int edgeValue) {
        this.node = node;
        this.edgeValue = edgeValue;
    }
}
