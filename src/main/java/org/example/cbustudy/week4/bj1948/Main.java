package org.example.cbustudy.week4.bj1948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int roadSize = Integer.parseInt(st.nextToken());

        int visitCount[] = new int[citySize + 1];
        List<Node>[] graph = new List[citySize + 1];
        List<Node>[] reverseGraph = new List[citySize + 1];
        for (int i = 1; i <= citySize; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < roadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, time));
            reverseGraph[end].add(new Node(start, time));
            visitCount[end]++;
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        int[] answer = new int[citySize + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node r : graph[now]) {
                visitCount[r.to]--;
                answer[r.to] = Math.max(answer[r.to], answer[now] + r.weight);
                if(visitCount[r.to] == 0) {
                    queue.add(r.to);
                }
            }
        }

        int answerCount = 0;
        boolean[] visited = new boolean[citySize + 1];
        visited[endNode] = true;
        queue.add(endNode);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node next : reverseGraph[now]) {
                if(answer[next.to] + next.weight == answer[now]) {
                    answerCount++;
                    if(!visited[next.to]) {
                        visited[next.to] = true;
                        queue.add(next.to);
                    }
                }
            }
        }
        sb.append(answer[endNode]).append("\n").append(answerCount).append("\n");


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}