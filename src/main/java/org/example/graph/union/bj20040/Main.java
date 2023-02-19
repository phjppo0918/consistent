package org.example.graph.union.bj20040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        parents = new int[nodeSize + 1];
        for (int i = 0; i < nodeSize + 1; i++) {
            parents[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if(node1 < node2) {
                int temp = node1;
                node1 = node2;
                node2 = temp;
            }
            int node1Parent = getParent(node1);
            int node2Parent = getParent(node2);
            if(node1Parent == node2Parent) {
                answer = i + 1;
                break;
            }
            parents[node1] = node1Parent;
            parents[node2] = node1Parent;
            parents[node2Parent] = node1Parent;
        }
        sb.append(answer);
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
