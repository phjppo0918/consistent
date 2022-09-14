package graph.bj1504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static List<Edge>[] graph;
    public static int nodeSize;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        graph = new List[nodeSize + 1];

        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[node1].add(new Edge(node2, value));
            graph[node2].add(new Edge(node1, value));
        }
        st = new StringTokenizer(br.readLine());
        int passPoint1 = Integer.parseInt(st.nextToken());
        int passPoint2 = Integer.parseInt(st.nextToken());

        int passTopassLength = getDest(passPoint1, passPoint2);
        int startToPass1 = getDest(1, passPoint1);
        int pass2ToEnd = getDest(passPoint2, nodeSize);


        int startToPass2 = getDest(1, passPoint2);
        int pass1ToEnd = getDest(passPoint1, nodeSize);


        int res1 = getRoad(startToPass1, passTopassLength, pass2ToEnd);
        int res2 = getRoad(startToPass2, passTopassLength, pass1ToEnd);

        if(res1 == Integer.MAX_VALUE && res2 == Integer.MAX_VALUE) {
            result.append(-1);
        }else {
            result.append(Math.min(res1, res2));
        }

        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static int getRoad(int startLength, int middleLength, int endLength) {
        if(startLength == -1 || middleLength == -1 || endLength == -1) {
            return Integer.MAX_VALUE;
        }

        return startLength + middleLength + endLength;
    }

    public static int getDest(int start, int end) {
        int [] dest = new int[nodeSize + 1];
        Arrays.fill(dest, Integer.MAX_VALUE);
        dest[start] = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for(Edge next : graph[now.node]) {
                if(dest[next.node] > dest[now.node] + next.value) {
                    dest[next.node] = dest[now.node] + next.value;
                    pq.add(new Edge(next.node, dest[next.node]));
                }
            }
        }

        if(dest[end] == Integer.MAX_VALUE) {
            return -1;
        }

        return dest[end];
    }
}
class Edge implements Comparable<Edge> {
    int node;
    int value;

    public Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}