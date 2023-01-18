package org.example.backtracking.bj2239;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board = new int[10][10];

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        List<Pair> inputPair = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i < 10; i++) {
            int[] arr = br.readLine().chars().map(c -> c - '0').toArray();
            for (int j = 1; j < 10; j++) {
                board[i][j] = arr[j-1];
                if(board[i][j] == 0) {
                    inputPair.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < inputPair.size(); i++) {
            Pair pair = inputPair.get(i);
            for (int j = 1; j <= 9; j++) {
                if(canPlace(pair.x, pair.y, j)) {
                    pair.canVisit.add(j);
                }
            }
            pair.visited = new boolean[pair.canVisit.size()];
        }

        int pivot = 0;
        while (pivot != inputPair.size()) {

            Pair pair = inputPair.get(pivot);
            boolean isInput = false;
            for (int i = 0; i < pair.canVisit.size(); i++) {
                int inputTemp = pair.canVisit.get(i);
                if(!pair.visited[i]&& canPlace(pair.x, pair.y, inputTemp)) {
                    board[pair.x][pair.y] =inputTemp;
                    pair.visited[i] = true;
                    isInput = true;
                    break;
                }
            }
            if(!isInput) {
                board[pair.x][pair.y] = 0;
                pair.visited = new boolean[pair.canVisit.size()];
                pivot--;
            }else {
                pivot++;
            }

        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                result.append(board[i][j]);
            }
            result.append("\n");
        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canPlace(int x, int y, int value) {
        return canRow(x, value) && canCol(y, value) && canBox(x, y, value);

    }

    private static boolean canCol(int y, int value) {
        for (int i = 1; i < 10; i++) {
            if (board[i][y] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean canRow(int x, int value) {
        for (int i = 1; i < 10; i++) {
            if (board[x][i] == value) {
                return false;
            }
        }
        return true;
    }

    // 123 : 1~3, 456 : 3~6, 789 : 6~9
    // 012 : 1, 345 : 2, 678 : 3

    private static boolean canBox(int x, int y, int value) {
        int boxX = ((x - 1) / 3 + 1) * 3;
        int boxY = ((y - 1) / 3 + 1) * 3;
        for (int i = boxX - 2; i <= boxX; i++) {
            for (int j = boxY - 2; j <= boxY; j++) {
                if(board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
class Pair {
    int x;
    int y;

    List<Integer> canVisit = new ArrayList<>();
    boolean[] visited;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}