package org.example.cbustudy.week5.bj1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX = 1_000_001;
        int[] dp = new int[MAX];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i < MAX; i++) {
            if(i % 3== 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

            if(i % 2== 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        int inp = Integer.parseInt(st.nextToken());
        sb.append(dp[inp]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
