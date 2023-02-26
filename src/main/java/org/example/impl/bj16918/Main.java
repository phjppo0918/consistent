package org.example.impl.bj16918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final static char BOMB = 'O';
    private final static int BLANK = 0;
    private final static int[] rowPivot = {-1, 1, 0, 0};
    private final static int[] colPivot = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][col];

        for (int i = 0; i < row; i++) {
            char temp[] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (temp[j] == BOMB) {
                    board[i][j] = 1;
                }
            }
        }

        for (int t = 2; t <= time; t++) {
            if (t % 2 == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if(board[i][j] == BLANK) {
                            board[i][j] = t+1;
                        }
                    }
                }
            } else {
                int target = t - 2;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if(board[i][j] == target) {
                            board[i][j] = BLANK;
                            for (int k = 0; k < 4; k++) {
                                try {
                                    if( board[i + rowPivot[k]][j + colPivot[k]] == target) {
                                        continue;
                                    }
                                    board[i + rowPivot[k]][j + colPivot[k]] = BLANK;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                }
                            }
                        }
                    }
                }
            }
        }



        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == BLANK) {
                    sb.append('.');
                }else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

//처음 판 상태
// 터지고 나서 판 상태
// 짝수 -> 전체 채우기