package org.example.graph.bj1647;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int max = Integer.MIN_VALUE;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int houseSize = Integer.parseInt(st.nextToken());
        int loadSize = Integer.parseInt(st.nextToken());
        visited = new boolean[houseSize + 1];
        List<Load>[] loads = new List[houseSize + 1];
        for (int i = 0; i < houseSize + 1; i++) {
            loads[i] = new ArrayList<>();
        }
        for (int i = 0; i < loadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            loads[node1].add(new Load(node2, value));
            loads[node2].add(new Load(node1, value));
        }
        int answer = 0;
        Queue<Load> queue = new PriorityQueue<>();
        queue.add(new Load(1, 0));
        while (!queue.isEmpty()) {
            Load load = queue.poll();
            if(visited[load.node]) {
                continue;
            }
            visited[load.node] = true;
            answer += load.value;
            max = Math.max(max, load.value);
            for(Load l : loads[load.node]) {
                if(!visited[l.node]) {
                    queue.add(l);
                }
            }
        }
        sb.append(answer - max);
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
class Load implements Comparable<Load> {
    int node;
    int value;

    public Load(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Load o) {
        return value - o.value;
    }
}