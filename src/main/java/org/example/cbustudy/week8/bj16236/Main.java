package org.example.cbustudy.week8.bj16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, -1, 1, 0}; // 상 , 좌 , 우, 하 우선
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[][] graph = new int[size][size];

        Queue<Node> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    queue.add(new Node(i, j, 0));
                    visit[i][j] = true;
                    graph[i][j] = 0;
                }
            }
        }
        int sharkSize = 2;
        int leftExp = sharkSize;


        int answer = 0;

        while (!queue.isEmpty()) {
            final Node now = queue.poll();

            if(graph[now.y][now.x]!= 0 && graph[now.y][now.x] < sharkSize) { //잡아먹자!
                leftExp--;
                if(leftExp == 0) {
                    sharkSize++;
                    leftExp = sharkSize;
                }
                answer += now.value;
                graph[now.y][now.x] = 0;
                visit = new boolean[size][size];
                visit[now.y][now.x] = true;
                queue.clear();
                now.value = 0;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= size || ny >= size || visit[ny][nx] || graph[ny][nx] > sharkSize) {
                    continue;
                }
                visit[ny][nx] = true;
                queue.add(new Node(ny, nx, now.value + 1));
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node implements Comparable<Node> {
    int y;
    int x;
    int value;

    public Node(final int y, final int x, final int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }

    @Override
    public int compareTo(final Node o) {
        if(value == o.value) {
            if(y == o.y) {
                return x - o.x;
            }
            return y - o.y;
        }
        return value - o.value;
    }
}
