package org.example.binarySearch.bj1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        board = new char[size][];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }
        search(0, 0, size);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void search(int row, int col, int size) {
        if(size == 1) {
            sb.append(board[row][col]);
            return;
        }


        if(checkPaper(row, col, size ,'1')) {
            sb.append("1");
            return;
        }
        if(checkPaper(row, col, size, '0')) {
            sb.append("0");
            return;
        }
        int nextSize = size/2;
        sb.append("(");
        //좌상
        search(row, col, nextSize);
        //좌하
        search(row, col +nextSize, nextSize);
        //우상
        search(row+ nextSize, col, nextSize);
        //우하
        search(row + nextSize, col + nextSize, nextSize);
        sb.append(')');
    }

    public static boolean checkPaper(int row, int col, int size, char color) {
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
