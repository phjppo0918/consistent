package org.example.graph.bfs.bj2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    private static final int OUT_SIDE = -1;
    private static final int MELT = -2;
    private static List<Pair> resentMelt;
    private static int row;
    private static int col;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row + 2][col + 2];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkOutSide(1, 1);
        int count = 0;
        while (true) {
            boolean isMeltAll = true;
            resentMelt = new ArrayList<>();
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (graph[i][j] == 1) {
                        checkMelt(i, j);
                        isMeltAll = false;
                    }
                }
            }
            if (isMeltAll) {
                break;
            }

            count++;
            resentMelt.forEach(p -> {
                graph[p.x][p.y] = 0;
                checkOutSide(p.x, p.y);
            });
        }
        result.append(count).append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void checkOutSide(int x, int y) {
        if (x < 1 || y < 1 || x > row || y > col) {
            return;
        }
        if (graph[x][y] == 0) {
            graph[x][y] = OUT_SIDE;
        } else {
            return;
        }
        checkOutSide(x - 1, y);
        checkOutSide(x + 1, y);
        checkOutSide(x, y - 1);
        checkOutSide(x, y + 1);
    }

    private static void checkMelt(int x, int y) {
        int meltPoint = 0;
        if (graph[x - 1][y] == OUT_SIDE) {
            meltPoint++;
        }
        if (graph[x + 1][y] == OUT_SIDE) {
            meltPoint++;
        }
        if(graph[x][y - 1] == OUT_SIDE) {
            meltPoint++;
        }
        if(graph[x][y + 1] == OUT_SIDE) {
            meltPoint++;
        }
        if(meltPoint >=2) {
            graph[x][y] = MELT;
            resentMelt.add(new Pair(x, y));
        }
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}