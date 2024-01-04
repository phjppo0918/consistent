package org.example.cbustudy.week8.bj2342;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int CENTER = 0;
    private static final int TOP = 1;
    private static final int RIGHT = 4;
    private static final int LEFT = 2;
    private static final int BOTTOM = 3;
    private static final int NOT_MOVE = Integer.MAX_VALUE;
    private static final int[] SEQ = {TOP, RIGHT, LEFT, BOTTOM, CENTER};
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[] move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][][] dp = new int[5][5][move.length + 1]; //왼발 위치, 오른발 위치, 순서

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= move.length; k++) {
                    dp[i][j][k] = NOT_MOVE;
                }
            }
        }

        dp[move[0]][0][0] = 2;
        dp[0][move[0]][0] = 2;

        for (int i = 1; i < move.length; i++) {
            int go = move[i];

            // move left
            for(int before : SEQ) {
                for(int right: SEQ) {
                    if(dp[before][right][i - 1] != NOT_MOVE) {
                        dp[go][right][i] = Math.min(dp[before][right][i - 1] + getPower(before, go), dp[go][right][i]);
                    }
                }
            }

            // move right
            for(int before : SEQ) {
                for(int left: SEQ) {
                    if(dp[left][before][i - 1] != NOT_MOVE) {
                        dp[left][go][i] = Math.min(dp[left][before][i - 1] + getPower(before, go), dp[left][go][i]);
                    }
                }
            }
        }


        int answer = Integer.MAX_VALUE;
        int ansPivot = move.length-2;

        for(int left : SEQ) {
            for(int right: SEQ) {
                if(dp[left][right][ansPivot] != NOT_MOVE) {
                    answer = Math.min(answer, dp[left][right][ansPivot]);
                }

            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int getPower(int start, int to) {
        if(start == to) {
            return 1;
        }
        if(start == CENTER || to == CENTER) {
            return 2;
        }
        if(Math.abs(start - to) == 2) {
            return 4;
        }
        return 3;
    }
}
