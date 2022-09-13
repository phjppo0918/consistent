package graph.bj1854;

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

        List<Road> graph[] = new List[citySize + 1];
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

            graph[start].add(new Road(end, time));
        }
        final int START_CITY = 1;
        pq[START_CITY].add(0);

        Queue<Road> roadQueue = new PriorityQueue<>();
        roadQueue.add(new Road(START_CITY,0));
        while (!roadQueue.isEmpty()){
            Road now = roadQueue.poll();

            for(Road next : graph[now.node]) {
                int nextValue = next.value + now.value;
                if(pq[next.node].size() < k) {
                    pq[next.node].add(nextValue);
                    roadQueue.add(new Road(next.node, nextValue));
                }else {
                    if(pq[next.node].peek() > nextValue) {
                        pq[next.node].poll();
                        pq[next.node].add(nextValue);
                        roadQueue.add(new Road(next.node, nextValue));
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

class Road implements Comparable<Road> {
    int node;
    int value;

    public Road(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Road o) {
        return this.value - o.value;
    }
}