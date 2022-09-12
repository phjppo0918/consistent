package graph.bj1753;

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

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        List<Road>[] graph = new List[nodeSize + 1];
        int leng[] = new int[nodeSize + 1];
        boolean visited[] = new boolean[nodeSize + 1];
        for (int i = 1; i <= nodeSize ; i++) {
            graph[i] = new ArrayList<>();
            leng[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Road(end, value));
        }

        Queue<Road> queue = new PriorityQueue<>();

        queue.add(new Road(startNode, 0));
        leng[startNode] = 0;

        while (!queue.isEmpty()) {
            Road now = queue.poll();
            if(visited[now.node]) {
                continue;
            }
            visited[now.node] = true;
            for(Road r : graph[now.node]) {
                leng[r.node] = Math.min(leng[now.node] + r.value , leng[r.node]);
                queue.add(new Road(r.node, leng[r.node]));
            }
        }


        for(int i=1;i<=nodeSize;i++) {
            if(leng[i] == Integer.MAX_VALUE) {
                result.append("INF");
            }else {
                result.append(leng[i]);
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
