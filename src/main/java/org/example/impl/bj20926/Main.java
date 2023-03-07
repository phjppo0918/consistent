package org.example.impl.bj20926;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static int[][] dist;
    static int w, h;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        w = Integer.parseInt(st.nextToken());
        h =Integer.parseInt(st.nextToken());
       //st = new StringTokenizer(br.readLine());
        board = new char[h][w];
        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;
        for(int i = 0; i < h; i++) {
            String str = br.readLine();
            for(int j = 0; j < w; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'T') {
                    startRow = i;
                    startCol = j;
                } else if(board[i][j] == 'E') {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        //입력 끝

        int defaultValue = Integer.MAX_VALUE;
        dist = new int[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(dist[i], defaultValue);
        }

        bfs(startRow, startCol);
        if(dist[endRow][endCol] == defaultValue) sb.append(-1);
        else sb.append(dist[endRow][endCol]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[h][w];
        q.offer(new Node(x, y, 0));
        dist[x][y] = 0;

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;

            for(int i = 0; i < 4; i++) {
                int goRatio = canGo(i, current.x, current.y);
                if(goRatio < 1) continue;

                int sum = 0;
                for(int j = 1; j <= goRatio; j++) {
                    if(board[current.x + dx[i] * j][current.y + dy[i] * j] == 'E') continue;
                    else sum += (board[current.x + dx[i] * j][current.y + dy[i] * j] - '0');
                }
                int nx = current.x + dx[i] * goRatio;
                int ny = current.y + dy[i] * goRatio;

                if(dist[nx][ny] > sum + current.time) {
                    dist[nx][ny] = sum + current.time;
                    q.offer(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
    }

    public static int canGo(int dir, int x, int y) {
        int ratio = 1;
        while(true) {
            int nx = x + dx[dir] * ratio;
            int ny = y + dy[dir] * ratio;

            if(nx < 0 || ny < 0 || nx >= h || ny >= w) break;
            if(board[nx][ny] == 'H') break;

            if(board[nx][ny] == 'R') return ratio - 1;
            if(board[nx][ny] == 'E' ) return ratio;

            ratio++;
        }
        return -1;
    }
}

class Node implements Comparable<Node>{
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Node n) {
        return this.time - n.time;
    }
}
