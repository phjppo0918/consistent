package org.example.cbustudy.week5.bj10844;

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

        final int OUT = 1_000_000_000;
        int num = Integer.parseInt(st.nextToken());
        long[][] dp = new long[num + 5][10];

        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % OUT;
            }
        }


        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[num][i];
        }

        sb.append(answer % OUT);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
