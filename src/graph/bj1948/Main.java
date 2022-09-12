package graph.bj1948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int roadSize = Integer.parseInt(st.nextToken());

        int count[] = new int[citySize + 1];
        List<Road>[] graph = new List[citySize + 1];
        List<Road>[] reverseGraph = new List[citySize + 1];
        for (int i = 1; i <= citySize; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < roadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Road(end, time));
            reverseGraph[end].add(new Road(start, time));
            count[end]++;
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        int[] answer = new int[citySize + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Road r : graph[now]) {
                count[r.node]--;
                answer[r.node] = Math.max(answer[r.node], answer[now] + r.value);
                if(count[r.node] == 0) {
                    queue.add(r.node);
                }
            }
        }

        int answerCount = 0;
        boolean[] visited = new boolean[citySize + 1];
        visited[endNode] = true;
        queue.add(endNode);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Road r : reverseGraph[now]) {
                if(answer[r.node] + r.value == answer[now]) {
                    answerCount++;
                    if(!visited[r.node]) {
                        visited[r.node] = true;
                        queue.add(r.node);
                    }
                }
            }
        }
        result.append(answer[endNode]);
        result.append("\n");
        result.append(answerCount);
        result.append("\n");


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Road {
    int node;
    int value;

    public Road(int node, int value) {
        this.node = node;
        this.value = value;
    }
}
