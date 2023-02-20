package org.example.graph.union.bj17398;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2 {
    static int[] parents;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int topSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int actSize = Integer.parseInt(st.nextToken());
        parents = new int[topSize + 1];
        count = new int[topSize + 1];

        for (int i = 0; i < topSize + 1; i++) {
            parents[i] = i;
            count[i] = 1;
        }
        List<Line2> lines = new ArrayList<>();
        List<Integer> cut = new ArrayList<>();
        boolean[] check = new boolean[edgeSize + 1];
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            lines.add(new Line2(node1, node2));
            check[i] = true;
        }
        long cost = 0;
        for (int i = 0; i < actSize; i++) {
            int target = Integer.parseInt(br.readLine()) - 1;
            cut.add(target);
            check[target] = false;
        }

        for (int i = 0; i < edgeSize; i++) {
            if(check[i]) merge(lines.get(i).node1, lines.get(i).node2);
        }

        for (int i = actSize - 1; i >= 0; i--) {
            Line2 line = lines.get(cut.get(i));
            int parent1 = getParent(line.node1);
            int parent2 = getParent(line.node2);
            if (parent1 != parent2) {
                cost += ((long) count[parent1] * count[parent2]);
            }

            merge(parent1, parent2);
        }

        sb.append(cost);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void merge(Integer node1, Integer node2) {
        int p1 = getParent(node1);
        int p2 = getParent(node2);

        if(p1 == p2) {
            return;
        }

        count[p1] += count[p2];
        parents[p2] = p1;
        parents[node2] = p1;
    }

    private static int getParent(int node) {
        if (node == parents[node]) {
            return node;
        }
        return parents[node] = getParent(parents[node]);
    }
}

class Line2 {
    Integer node1;
    Integer node2;

    public Line2(Integer node1, Integer node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}
