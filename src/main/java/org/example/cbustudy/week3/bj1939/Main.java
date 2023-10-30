package org.example.cbustudy.week3.bj1939;

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

        int nodeSize = Integer.parseInt(st.nextToken());
        int bridgeSize = Integer.parseInt(st.nextToken());

        List<Bridge>[] graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < bridgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[n1].add(new Bridge(n2, weight));
            graph[n2].add(new Bridge(n1, weight));
        }

        for (int i = 1; i <= nodeSize; i++) {
            Collections.sort(graph[i]);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new PriorityQueue<>();
        int[] max = new int[nodeSize + 1];
        Arrays.fill(max, Integer.MIN_VALUE);
        max[start] = Integer.MAX_VALUE;
        queue.add(start);
        boolean isFin = false;

        while (!queue.isEmpty() || !isFin) {
            int now = queue.poll();

            for(Bridge b : graph[now]) {
                int nextWeight = Math.min(max[now], b.weight);
                if(max[b.go] < nextWeight) {
                    max[b.go] = nextWeight;
                    if(b.go == end) {
                        isFin = true;
                        break;
                    }
                    queue.add(b.go);
                }
            }
        }


        sb.append(max[end]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Bridge implements Comparable<Bridge> {
    int go;
    int weight;

    public Bridge(int go, int weight) {
        this.go = go;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bridge o) {
        return o.weight - weight;
    }
}