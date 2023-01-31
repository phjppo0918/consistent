package org.example.binarySearch.bj10830;

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

        int boardSize = Integer.parseInt(st.nextToken());
        long powCount = Long.parseLong(st.nextToken());
        int[][] board = new int[boardSize][];

        for (int i = 0; i < boardSize; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(e -> e%1000)
                    .toArray();
        }

        int[][] answer = pow(powCount, board);
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }

    private static int[][] pow(long powCount, int[][] board) {
        if (powCount == 1) {
            return board.clone();
        }
        int[][] res = pow(powCount / 2, mul(board, board));
        if (powCount % 2 == 1) {
            res = mul(res, board);
        }
        return res;
    }

    private static int[][] mul(int[][] p1, int[][] p2) {
        int[][] res = new int[p1.length][p2.length];
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p2.length; j++) {
                for (int k = 0; k < p2.length; k++) {
                    res[i][j] += (p1[i][k] * p2[k][j]) % 1000;
                    res[i][j] %= 1000;
                }
            }
        }

        return res;
    }
}
