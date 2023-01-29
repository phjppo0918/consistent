package org.example.binarySearch.bj2630;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static final int BLUE = 1;
    private static final int WHITE = 0;
    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        board = new int[size][];
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        search(0, 0, size);
        sb.append(whiteCount).append("\n").append(blueCount);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void search(int row, int col, int size) {
        if(size == 1) {
            if(board[row][col] == BLUE) {
                blueCount++;
            }else {
                whiteCount++;
            }
            return;
        }

        if(checkPaper(row, col, size ,BLUE)) {
            blueCount++;
            return;
        }
        if(checkPaper(row, col, size, WHITE)) {
            whiteCount++;
            return;
        }
        int nextSize = size/2;

        //좌상
        search(row, col, nextSize);
        //우상
        search(row+ nextSize, col, nextSize);
        //좌하
        search(row, col +nextSize, nextSize);
        //우하
        search(row + nextSize, col + nextSize, nextSize);

    }

    public static boolean checkPaper(int row, int col, int size, int color) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
