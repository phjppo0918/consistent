package org.example.cbustudy.week5.bj2193;

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

        int num = Integer.parseInt(st.nextToken());

        long[] dp = new long[num + 4];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for (int i = 5; i < num + 3; i++) {
            for (int j = 0; j <= i-2; j++) {
                dp[i] += dp[j];
            }
        }


        sb.append(dp[num]);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
