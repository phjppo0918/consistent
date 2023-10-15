package org.example.dbn.bj1743;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static boolean[][] graph;
    static boolean[][] visited;
    static int maxCount = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        int tSize = Integer.parseInt(st.nextToken());

        graph = new boolean[colSize + 1][rowSize + 1];
        visited = new boolean[colSize + 1][rowSize + 1];

        List<Pair> start = new ArrayList<>();
        for (int i = 0; i < tSize; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            start.add(new Pair(col, row));
            graph[col][row] = true;
        }

        for (Pair p : start) {
            if (visited[p.col][p.row]) {
                continue;
            }
            Queue<Pair> queue = new LinkedList<>();
            queue.add(p);
            int count = 0;
            visited[p.col][p.row] = true;
            while (!queue.isEmpty()) {
                count++;
                Pair now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextCol = now.col + dx[i];
                    int nextRow = now.row + dy[i];

                    if (nextCol <= 0 || nextRow <= 0 || nextCol > colSize || nextRow > rowSize) {
                        continue;
                    }

                    if (graph[nextCol][nextRow] && !visited[nextCol][nextRow]) {
                        queue.add(new Pair(nextCol, nextRow));
                        visited[nextCol][nextRow] = true;
                    }
                }
            }

            if(count > maxCount) {
                maxCount = count;
            }
        }
        sb.append(maxCount);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Pair {
    int col;
    int row;

    public Pair(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
