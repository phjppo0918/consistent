package org.example.graph.union.bj16562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final String CANT = "Oh no";
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        parents = new int[studentSize + 1];
        for (int i = 0; i < studentSize + 1; i++) {
            parents[i] = i;
        }
        int[] needs = new int[studentSize + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= studentSize; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int node1Parent = getParent(node1);
            int node2Parent = getParent(node2);
            parents[node2Parent] = node1Parent;
            needs[node1Parent] = Math.min(needs[node2Parent], needs[node1Parent]);
        }
        int totalmoney = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i < studentSize + 1; i++) {
            if (visited.contains(getParent(i))) continue;

            visited.add(getParent(i));
            totalmoney += needs[getParent(i)];
        }
        if (money < totalmoney) {
            sb.append(CANT);
        } else {
            sb.append(totalmoney);
        }
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
