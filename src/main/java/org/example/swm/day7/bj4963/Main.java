package org.example.swm.day7.bj4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        while (col != 0 || row != 0) {

            int[][] board = new int[row][col];
            for (int i = 0; i < row; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int count = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 1) {
                        count++;
                        search(board, i, j);
                    }
                }
            }

            System.out.println(count);
            //sb.append(count).append("\n");


            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(final int[][] board, int x, int y) {
        board[x][y] = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if(board[x + i][y + j]== 1){
                        search(board, x + i, y + j);
                    }
                } catch (Exception e) {
                }
            }
        }

    }
}
