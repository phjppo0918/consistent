package graph.bj11779;

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
        int busSize = Integer.parseInt(st.nextToken());
        int costs[] = new int[citySize+ 1];
        boolean visited[] = new boolean[citySize + 1];
        List<Bus>[] graph = new List[citySize + 1];
        for (int i = 1; i <= citySize ; i++) {
            graph[i] = new ArrayList<>();
            costs[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < busSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        costs[start] = 0;
        Queue<Bus> queue = new PriorityQueue<>();
        List<Integer> startArr = new ArrayList<>();
        startArr.add(start);
        queue.add(new Bus(start, 0, startArr));

        List<Integer> answerLocation = new ArrayList<>();

        while (!queue.isEmpty()) {
            Bus now = queue.poll();
            if(visited[now.node]) {
                continue;
            }
            visited[now.node] = true;

            for(Bus next: graph[now.node]) {
                int nextCost = next.cost + costs[now.node];
                if(nextCost < costs[end] &&  nextCost < costs[next.node]) {
                    costs[next.node] = nextCost;
                    List<Integer> nextArr = new ArrayList<>(now.location);
                    nextArr.add(next.node);
                    queue.add(new Bus(next.node, nextCost, nextArr));

                    if(next.node == end) {
                        answerLocation = new ArrayList<>(nextArr);
                    }
                }
            }
        }

        result.append(costs[end]);
        result.append("\n");
        result.append(answerLocation.size());
        result.append("\n");
        answerLocation.forEach(i -> {
            result.append(i);
            result.append(" ");
        });
        result.append("\n");



        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
class Bus implements Comparable<Bus>{
    int node;
    int cost;

    List<Integer> location = new ArrayList<>();

    public Bus(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public Bus(int node, int cost, List<Integer> location) {
        this.node = node;
        this.cost = cost;
        this.location = location;
    }

    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;
    }
}
