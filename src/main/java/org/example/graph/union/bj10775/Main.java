package org.example.graph.union.bj10775;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int[] parents;

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int gSize = Integer.parseInt(br.readLine());
        int pSize = Integer.parseInt(br.readLine());

        parents = new int[gSize + 1];
        for (int i = 0; i < gSize + 1; i++) {
            parents[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < pSize; i++) {
            int p = Integer.parseInt(br.readLine());
            int parent = getParent(p);
            if(parent == 0) {
                answer = i;
                break;
            }
            if(i == pSize - 1) {
                answer = pSize;
                break;
            }
            parents[p] = getParent(parents[parent - 1]);
            parents[parent] = getParent(parents[parent - 1]);
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
