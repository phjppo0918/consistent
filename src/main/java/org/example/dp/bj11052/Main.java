package org.example.dp.bj11052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[size + 1];
        dp[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= size; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }
        result.append(dp[size]);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
/*
풀이 순서
dp[0] = 0;
첨에 DP 값으로 1~N 그대로 넣기!
바텀업으로 구함
dp[N]을 구할 때 dp[N-K] + dp[K] 중 제일 큰거 넣기
 */