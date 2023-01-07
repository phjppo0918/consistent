package org.example.graph.bfs.bj2573;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] isGlacier;
    static boolean[][] union;



    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        isGlacier = new boolean[row][col];
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > 0) {
                    isGlacier[i][j] = true;
                    pairs.add(new Pair(i,j));
                }
            }
        }
        int answer = -1;
        int yearCount = 0;
        while (answer == -1) {
            int checkValue = checkDivide(row, col);
            if(checkValue == 0) {
                answer = 0;
            }else if(checkValue >= 2) {
                answer = yearCount;
            }
            List<Pair> meltAll = new ArrayList<>();
            pairs.forEach(p -> {
                if(isGlacier[p.x][p.y]) {
                    int r = melt(p.x, p.y);
                    if (r == 0) {
                        meltAll.add(p);
                    }
                }
            });

            meltAll.forEach(p -> isGlacier[p.x][p.y] = false);

            yearCount++;
        }

        result.append(answer);


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int checkDivide(int row, int col) {
        int lumpCount = 0;
        boolean[][] union = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            union[i] = isGlacier[i].clone();
        }
        for (int i = 0; i < union.length; i++) {
            for (int j = 0; j < union[i].length; j++) {
                if (union[i][j]) {
                    lumpCount++;
                    toBreak(union, i, j);
                }
            }
        }
        return lumpCount;
    }

    static void toBreak(boolean[][] union, int x, int y) {
        if (!union[x][y]) {
            return;
        }
        union[x][y] = false;
        toBreak(union, x - 1, y);
        toBreak(union, x + 1, y);
        toBreak(union, x, y - 1);
        toBreak(union, x, y + 1);
    }

    static int melt(int x, int y) {
        if (!isGlacier[x - 1][y]) {
            graph[x][y]--;
        }
        if (!isGlacier[x + 1][y]) {
            graph[x][y]--;
        }
        if (!isGlacier[x][y - 1]) {
            graph[x][y]--;
        }
        if (!isGlacier[x][y + 1]) {
            graph[x][y]--;
        }

        if (graph[x][y] <= 0) {
            graph[x][y] = 0;
        }
        return graph[x][y];
    }
}
class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
