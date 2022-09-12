package graph.bj1916;

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
        queue.add(new Bus(start, 0));

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
                    queue.add(new Bus(next.node, nextCost));
                }
            }
        }

        result.append(costs[end]);
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

    public Bus(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;
    }
}
