package org.example.cbustudy.week5.bj1915;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] graph = new char[row][col];
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            final String str = br.readLine();
            for (int j = 0; j < col; j++) {
                graph[i][j] = str.charAt(j);
                dp[i][j] = str.charAt(j) - '0';
                max = Math.max(max,dp[i][j]);
            }
        }




        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    dp[i][j]++;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        sb.append(max * max);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
