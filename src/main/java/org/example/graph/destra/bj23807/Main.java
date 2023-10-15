package org.example.graph.destra.bj23807;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static List<Road>[] graph;
    private static int nodeSize;
    private static long[][] dp;
    private static long[] startDp;
    private static long[] endDp;
    private static int[] ic;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        graph = new List[nodeSize + 1];

        for (int i = 1; i <=  nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Road(end, value));
            graph[end].add(new Road(start, value));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int icSize = Integer.parseInt(br.readLine());
        ic = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long answer = Long.MAX_VALUE;
        dp = new long[icSize + 1][icSize + 1];
        startDp = new long[icSize + 1];
        endDp = new long[icSize + 1];
        Arrays.fill(startDp, -1);
        Arrays.fill(endDp, -1);
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < icSize; i++) {

            long length = getStart(start, i);
            if(length == Long.MAX_VALUE) {
                continue;
            }
            for (int j = i+1; j < icSize; j++) {
                if( j == i) {
                    continue;
                }
                long length2 = getValue(i, j);
                if(length2 == Long.MAX_VALUE) {
                    continue;
                }

                for (int k = j+1; k < icSize; k++) {
                    if( k == i || k == j) {
                        continue;
                    }
                    long length3 = getValue(j, k);
                    if(length3 != Long.MAX_VALUE) {
                        long length4 = getEnd(k, end);
                        if(length4 != Long.MAX_VALUE) {
                            answer = Math.min(answer, length + length2 + length3 + length4);
                        }
                    }
                }
            }
        }
        if(answer == Long.MAX_VALUE) {
            sb.append(-1);
        }else {
            sb.append(answer);
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static long getLength(int start, int end) {
        long[] values = new long[nodeSize + 1];
        Arrays.fill(values, Long.MAX_VALUE);
        values[start] = 0;
        Queue<Line> queue = new PriorityQueue<>();
        queue.add(new Line(start, 0));
        while (!queue.isEmpty()) {
            Line now = queue.poll();
            for(Road r : graph[now.node]) {
                if(values[r.end] > values[now.node] + r.value) {
                    values[r.end] = values[now.node] + r.value;
                    queue.add(new Line(r.end, values[r.end]));
                }
            }
        }
        return values[end];
    }

    private static long getStart(int start, int end) {
        if(startDp[end] == -1) {
            long value = getLength(start, ic[end]);
            startDp[end] = value;
        }

        return startDp[end];
    }

    private static long getEnd(int start, int end) {
        if(endDp[start] == -1) {
            long value = getLength(ic[start], end);
            endDp[start] = value;
        }

        return endDp[start];
    }

    private static long getValue(int start, int end) {
        if(dp[start][end] == -1) {
            long value = getLength(ic[start], ic[end]);
            dp[start][end] = value;
            dp[end][start] = value;
        }

        return dp[start][end];
    }
}

class Line implements Comparable<Line> {
    int node;
    long value;

    public Line(int node, long value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Line o) {
        return (int)(value - o.value);
    }
}

class Road {
    int end;
    long value;

    public Road(int end, long value) {
        this.end = end;
        this.value = value;
    }
}