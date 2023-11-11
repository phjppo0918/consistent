package org.example.swm.day14.bj16174;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final String CAN = "HaruHaru";
    private static final String CANT = "Hing";

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[][] graph = new int[size][];
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowJump = graph[now.x][now.y];
            int nextX = nowJump + now.x;
            int nextY = nowJump + now.y;

            if(nextX < size &&  !visited[nextX][now.y]) {
                visited[nextX][now.y] = true;
                queue.add(new Point(nextX, now.y));
            }
            if(nextY < size &&  !visited[now.x][nextY]) {
                visited[now.x][nextY] = true;
                queue.add(new Point(now.x, nextY));
            }
        }

        if(visited[size-1][size-1]) {
            sb.append(CAN);
        }else {
            sb.append(CANT);
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Point {
    int x;
    int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
