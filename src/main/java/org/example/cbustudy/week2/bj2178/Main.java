package org.example.cbustudy.week2.bj2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[][] step;

    static int rowSize;
    static int colSize;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        graph = new int[rowSize][colSize];
        step = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            final String line = br.readLine();
            for (int j = 0; j < colSize; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
            Arrays.fill(step[i], Integer.MAX_VALUE);
        }
        step[0][0] = 1;
        move(0, 0);

        sb.append(step[rowSize - 1][colSize - 1]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void move(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];
            if (!isOver(nextRow, nextCol) && graph[nextRow][nextCol] == 1 && step[nextRow][nextCol] > step[row][col] + 1) {
                step[nextRow][nextCol] = step[row][col] + 1;
                move(nextRow, nextCol);
            }

        }
    }

    private static boolean isOver(int row, int col) {
        return row < 0 || row >= rowSize || col < 0 || col >= colSize;
    }
}
