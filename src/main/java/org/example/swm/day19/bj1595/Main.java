package org.example.swm.day19.bj1595;


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

        Map<Integer, List<Node>> graph = new HashMap<>();

        int max = 0;

        try {
            while (st.hasMoreElements()) {
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int length = Integer.parseInt(st.nextToken());
                graph.putIfAbsent(node1, new ArrayList<>());
                graph.putIfAbsent(node2, new ArrayList<>());

                graph.get(node1).add(new Node(node2, length));
                graph.get(node2).add(new Node(node1, length));
                String k = br.readLine();
                if(k == null) {
                    break;
                }
                st = new StringTokenizer(k);
            }
        }catch (NullPointerException e) {}


        for (Integer key : graph.keySet()) {
            if (graph.get(key).size() > 1) {
                continue;
            }
            int maxtemp = bfs(graph, key);
            max = Math.max(max, maxtemp);
        }
        sb.append(max);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(final Map<Integer, List<Node>> graph, int start) {
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(start, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            for (Node n : graph.get(next.next)) {
                if (visited.containsKey(n.next)) {
                    continue;
                }
                visited.put(n.next, visited.get(next.next) + n.length);
                queue.add(n);
            }
        }

        return visited.values().stream().max(Comparator.comparingInt(a -> a)).orElse(0);
    }
}

class Node {
    int next;
    int length;

    public Node(final int next, final int length) {
        this.next = next;
        this.length = length;
    }
}
