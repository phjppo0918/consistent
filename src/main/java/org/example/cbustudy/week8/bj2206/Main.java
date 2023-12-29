package org.example.cbustudy.week8.bj2206;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        boolean[][] isWall = new boolean[height][width];
        int[][] count = new int[height][width];
        int[][] countBreak = new int[height][width];

        for (int i = 0; i < height; i++) {
            String temp = br.readLine();
            for (int j = 0; j < width; j++) {
                if (temp.charAt(j) == '1') {
                    isWall[i][j] = true;
                }
                count[i][j] = Integer.MAX_VALUE;
                countBreak[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, false));
        count[0][0] = 1;
        countBreak[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
                    continue;
                }
                if (now.isBreak) {
                    final int nextCount = countBreak[now.y][now.x] + 1;
                    if (!isWall[ny][nx] && nextCount < count[ny][nx] && nextCount < countBreak[ny][nx]) {
                        queue.add(new Node(ny, nx, true));
                        countBreak[ny][nx] = nextCount;
                    }
                } else {
                    final int nextCount = count[now.y][now.x] + 1;
                    if (!isWall[ny][nx] && nextCount < count[ny][nx]) {
                        queue.add(new Node(ny, nx, false));
                        count[ny][nx] = nextCount;
                    }
                    if(isWall[ny][nx] && nextCount < countBreak[ny][nx]) {
                        queue.add(new Node(ny, nx, true));
                        countBreak[ny][nx] = nextCount;
                    }
                }

            }


        }


        int answer = Math.min(countBreak[height - 1][width - 1], count[height - 1][width - 1]);
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int y;
    int x;
    boolean isBreak;

    public Node(final int y, final int x, boolean isBreak) {
        this.y = y;
        this.x = x;
        this.isBreak = isBreak;
    }
}
