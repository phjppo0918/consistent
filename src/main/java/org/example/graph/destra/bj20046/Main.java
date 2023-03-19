package org.example.graph.destra.bj20046;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static int rowSize;
    private static int colSize;
    private static int[] rowPivot = {-1, 1, 0, 0};
    private static int[] colPivot = {-0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        int[][] cost = new int[rowSize][colSize];
        int[][] graph = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        if (graph[0][0] == -1) {
            sb.append(-1);
        } else {
            Queue<Pair> pairs = new PriorityQueue<>();
            cost[0][0] = graph[0][0];
            pairs.add(new Pair(0, 0, cost[0][0]));
            while (!pairs.isEmpty()) {
                Pair now = pairs.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = now.row + rowPivot[i];
                    int nextCol = now.col + colPivot[i];
                    if (!outOfRange(nextRow, nextCol)
                            && graph[nextRow][nextCol] != -1
                            && cost[nextRow][nextCol] > cost[now.row][now.col] + graph[nextRow][nextCol]) {
                        cost[nextRow][nextCol] = cost[now.row][now.col] + graph[nextRow][nextCol];
                        pairs.add(new Pair(nextRow, nextCol, cost[nextRow][nextCol]));
                    }
                }
            }

            if(cost[rowSize-1][colSize -1] == Integer.MAX_VALUE) {
                sb.append(-1);
            }else {
                sb.append(cost[rowSize-1][colSize -1]);
            }
        }



        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean outOfRange(int row, int col) {
        if (row < 0 || row >= rowSize || col < 0 || col >= colSize) {
            return true;
        }
        return false;
    }
}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int value;

    public Pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return value - o.value;
    }
}
