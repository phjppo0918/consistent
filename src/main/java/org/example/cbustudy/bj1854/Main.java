package org.example.cbustudy.bj1854;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int roadSize = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new List[citySize + 1];
        Queue<Integer>[] pq = new Queue[citySize + 1];

        for (int i = 1; i <= citySize; i++) {
            graph[i] = new ArrayList<>();
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < roadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, time));
        }
        final int START_CITY = 1;
        pq[START_CITY].add(0);

        Queue<Node> nodeQueue = new PriorityQueue<>();
        nodeQueue.add(new Node(START_CITY,0));
        while (!nodeQueue.isEmpty()){
            Node now = nodeQueue.poll();

            for(Node next : graph[now.to]) {
                int nextValue = next.value + now.value;
                if(pq[next.to].size() < k) {
                    pq[next.to].add(nextValue);
                    nodeQueue.add(new Node(next.to, nextValue));
                }else {
                    if(pq[next.to].peek() > nextValue) {
                        pq[next.to].poll();
                        pq[next.to].add(nextValue);
                        nodeQueue.add(new Node(next.to, nextValue));
                    }
                }
            }
        }

        for (int i = 1; i <= citySize; i++) {
            if(pq[i].size() < k) {
                result.append(-1);
            }else {
                result.append(pq[i].peek());
            }
            result.append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node implements Comparable<Node> {
    int to;
    int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}