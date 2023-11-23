package org.example.cbustudy.week6.bj17472;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] graph;
    static int[] union;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int idIdx = 2;
        //섬 찾기
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 1) {
                    setSum(i, j, idIdx);
                    idIdx++;
                }
            }
        }
        union = new int[idIdx + 3];
        for (int i = 2; i < idIdx; i++) {
            union[i] = i;
        }
        Queue<Node> queue = new PriorityQueue<>();

        //다리 찾기

        //가로
        for (int i = 0; i < y; i++) {
            for (int j = 1; j < x; j++) {
                if(graph[i][j] == 0 && graph[i][j-1] != 0) {
                    int start = graph[i][j-1];
                    int startIdx = j;
                    while (j < x && graph[i][j] == 0) {
                        j++;
                    }
                    int value = j - startIdx;
                    if(j != x && value > 1) {
                        int end = graph[i][j];

                        queue.add(new Node(start, end, value));
                    }
                }
            }
        }
        // 세로
        for (int i = 0; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if(graph[j][i] == 0 && graph[j-1][i] != 0) {
                    int start = graph[j-1][i];
                    int startIdx = j;
                    while (j < y && graph[j][i] == 0) {
                        j++;
                    }
                    int value = j - startIdx;
                    if(j != y && value > 1) {
                        int end = graph[j][i];

                        queue.add(new Node(start, end, value));
                    }
                }
            }
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            final Node n = queue.poll();
            if(union(n.start) == union(n.end)) {
                continue;
            }
            answer += n.value;
            union[union(n.end)] = union(n.start);
        }

        int uv = union(2);
        for (int i = 3; i < idIdx; i++) {
            if(uv != union(i)) {
                answer = -1;
                break;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int union(int n) {
        if (union[n] == n) {
            return n;
        }

        union[n] = union(union[n]);
        return union[n];
    }

    private static void setSum(int y, int x, int id) {
        graph[y][x] =id;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (!isOver(nextY, nextX) && graph[nextY][nextX] == 1) {
                setSum(nextY, nextX, id);
            }
        }
    }

    private static boolean isOver(int y, int x) {
        return y < 0 || x < 0 || y >= graph.length || x >= graph[0].length;
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int value;

    public Node(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
