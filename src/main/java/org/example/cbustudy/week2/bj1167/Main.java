package org.example.cbustudy.week2.bj1167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> graph[];
    static boolean visited[];

    static int range[];

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        graph = new List[nodeSize + 1];
        range = new int[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeSize; i++) {
            final String[] s = br.readLine().split(" ");
            int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            int node = arr[0];
            for (int j = 1; j < arr.length - 1; j += 2) {
                int next = arr[j];
                int value = arr[j + 1];
                graph[node].add(new Node(next, value));
            }
        }
        backTracking(1, 0);

        int maxRangeIndex = 1;
        int maxRange = Integer.MIN_VALUE;
        for (int i = 1; i <= nodeSize; i++) {
            if (range[i] > maxRange) {
                maxRangeIndex = i;
                maxRange = range[i];
            }
        }

        int answer = backTracking(maxRangeIndex, 0);

        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int backTracking(int node, int total) {
        visited[node] = true;
        int maxTotal = total;
        range[node] = Math.max(range[node],total);
        for (Node next : graph[node]) {
            if (!visited[next.next]) {
                maxTotal = Math.max(maxTotal, backTracking(next.next, total + next.value));

            }
        }
        visited[node] = false;


        return maxTotal;
    }
}

class Node {
    int next;
    int value;

    public Node(int next, int value) {
        this.next = next;
        this.value = value;
    }
}
