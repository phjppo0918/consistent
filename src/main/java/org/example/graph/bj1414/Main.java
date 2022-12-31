package graph.bj1414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static Queue<Line> queue;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computerSize = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        parent = new int[computerSize];
        for (int i = 0; i < computerSize; i++) {
            parent[i] = i;
        }

        int totalLength = 0;
        for (int i = 0; i < computerSize; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 0; j < computerSize; j++) {
                int value = 0;

                if (array[j] =='0') {
                    continue;
                }

                if ('a' <= array[j] && array[j] <= 'z') {
                    value = array[j] - 'a' + 1;
                } else {
                    value = array[j] - 'A' + 27;
                }

                totalLength += value;
                queue.add(new Line(i, j, value));
            }
        }


        while (!queue.isEmpty()) {
            Line now = queue.poll();
            if (isSameParent(now.node1, now.node2)) {
                continue;
            }

            union(now.node1, now.node2);
            totalLength -= now.value;

        }

        boolean isConnection = true;
        for (int i = 1; i < computerSize; i++) {
            if (!isSameParent(parent[0], parent[i])) {
                isConnection = false;
                break;
            }
        }

        if (isConnection) {
            result.append(totalLength);
        } else {
            result.append(-1);
        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int node1, int node2) {
        if (node1 == node2) {
            return;
        }

        parent[getParent(node2)] = getParent(node1);
    }

    public static int getParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = getParent(parent[node]);
    }

    public static boolean isSameParent(int node1, int node2) {
        return getParent(node1) == getParent(node2);
    }
}

class Line implements Comparable<Line> {
    int node1;
    int node2;
    int value;

    public Line(int node1, int node2, int value) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }

    @Override
    public int compareTo(Line o) {
        return this.value - o.value;
    }
}
