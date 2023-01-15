package org.example.backtracking.bj1941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static char[][] graph = new char[5][];
    private static List<Pair> pairs = new ArrayList<>();
    private static List<Pair> move = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pairs.add(new Pair(i, j));
            }
        }
        for (int i = 0; i < 25; i++) {
            dfs(1, i);
        }

        result.append(count);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int dep, int start) {
        move.add(pairs.get(start));
        if (dep == 7) {
            if (isCheck()) {
                count++;
            }
            move.remove(6);
            return;
        }

        for (int i = start + 1; i < 25; i++) {
            dfs(dep + 1, i);
        }
        move.remove(dep - 1);

    }

    private static boolean isCheck() {
        boolean[][] union = new boolean[5][5];
        int sCount = 0;
        for (Pair p : move) {
            union[p.x][p.y] = true;
            if (graph[p.x][p.y] == 'S') {
                sCount++;
            }
        }
        if (sCount < 4) {
            return false;
        }

        toChange(union, move.get(0).x, move.get(0).y);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (union[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void toChange(boolean[][] union, int x, int y) {
        union[x][y] = false;
        if (x > 0 && union[x - 1][y]) {
            toChange(union, x - 1, y);
        }
        if (x < 4 && union[x + 1][y]) {
            toChange(union, x + 1, y);
        }
        if (y > 0 && union[x][y - 1]) {
            toChange(union, x, y - 1);
        }
        if (y < 4 && union[x][y + 1]) {
            toChange(union, x, y + 1);
        }
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
