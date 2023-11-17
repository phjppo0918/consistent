package org.example.cbustudy.week5.bj11726;

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

        final int DIVIDE = 10007;
        int[] dp = new int[num + 5]; //세로 시작
        int[] dp2 = new int[num + 5]; // 가로시작
        dp[1] = 1;
        dp2[1] = 0;
        dp[2] = 1;
        dp2[2] = 1;
        dp[3] = 2;
        dp2[3] = 1;

        for (int i = 4; i <= num+1; i++) {
            dp[i] = (dp[i-1] + dp2[i-1])%DIVIDE;
            dp2[i] = (dp[i-2] + dp2[i-2])%DIVIDE;
        }


        sb.append((dp[num] + dp2[num])%DIVIDE);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
