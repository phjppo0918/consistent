package org.example.cbustudy.week5.bj1328;

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


        final int DIV = 1_000_000_007;
        int bCount = Integer.parseInt(st.nextToken());
        int lCount = Integer.parseInt(st.nextToken());
        int rCount = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[103][103][103];
        dp[1][1][1] = 1;

        for (int i = 2; i <= bCount; i++) {
            for (int j = 1; j <= lCount; j++) {
                for (int k = 1; k <= rCount; k++) {
                    dp[i][j][k] = (dp[i - 1][j][k] * (i - 2) +
                            dp[i - 1][j - 1][k] +
                            dp[i - 1][j][k - 1]) / DIV;
                }
            }
        }


        sb.append(dp[bCount][lCount][rCount]);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
