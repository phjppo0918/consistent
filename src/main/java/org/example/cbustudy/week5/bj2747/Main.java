package org.example.cbustudy.week5.bj2747;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[48];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < 48; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int inp = Integer.parseInt(st.nextToken());

        sb.append(dp[inp]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
