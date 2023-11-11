package org.example.swm.day7.bj14502;

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

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int b1 = 0; b1 < row * col; b1++) {
            final Point b1p = new Point(b1, col);
            if (board[b1p.row][b1p.col] != 0) {
                continue;
            }
            for (int b2 = b1+1; b2 < row * col; b2++) {
                final Point b2p = new Point(b2, col);
                if (board[b2p.row][b2p.col] != 0) {
                    continue;
                }
                for (int b3 = b2+1; b3 < row * col; b3++) {
                    final Point b3p = new Point(b3, col);
                    if (board[b3p.row][b3p.col] != 0) {
                        continue;
                    }

                    int[][] temp = arrCopy(board);
                    temp[b1p.row][b1p.col] = 1;
                    temp[b2p.row][b2p.col] = 1;
                    temp[b3p.row][b3p.col] = 1;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            runBirus(temp, i, j);
                        }
                    }

                    ans = Math.max(ans, countSafeZone(temp));
                }
            }
        }
        sb.append(ans);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int countSafeZone(final int[][] temp) {
        int count = 0;
        for (final int[] ints : temp) {
            for (int j = 0; j < temp[0].length; j++) {
                if (ints[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void runBirus(final int[][] temp, int x, int y) {
        if (temp[x][y] == 2) {
            //상
            if (x - 1 >= 0 && temp[x - 1][y] == 0) {
                temp[x - 1][y] = 2;
                runBirus(temp, x - 1, y);
            }

            //하
            if (x + 1 < temp.length && temp[x + 1][y] == 0) {
                temp[x + 1][y] = 2;
                runBirus(temp, x + 1, y);
            }
            //좌
            if (y - 1 >= 0 && temp[x][y - 1] == 0) {
                temp[x][y - 1] = 2;
                runBirus(temp, x, y - 1);
            }
            //우

            if (y + 1 < temp[0].length && temp[x][y + 1] == 0) {
                temp[x][y + 1] = 2;
                runBirus(temp, x, y + 1);
            }
        }
    }

    private static int[][] arrCopy(final int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            result[i] = board[i].clone();
        }

        return result;
    }
}

class Point {
    int row;
    int col;

    Point(int k, int minCol) {
        row = k / minCol;
        col = k % minCol;
    }
}
