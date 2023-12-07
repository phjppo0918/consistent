package org.example.cbustudy.week6.bj11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] parent = new int[size + 1];
        parent[1] = 1;
        List<Integer>[] graph = new List[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < size - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            final Integer now = queue.poll();
            for(int next : graph[now]) {
                if(parent[next] == 0) {
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
        for (int i = 2; i <=size ; i++) {
            sb.append(parent[i]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
