package org.example.swm.day14.bj13910;

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

        int jCount = Integer.parseInt(st.nextToken());
        int wCount = Integer.parseInt(st.nextToken());

        int[] dp = new int[jCount *2];
        final int[] ws = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < wCount-1; i++) {
            for (int j =i+1; j < wCount; j++) {
                dp[ws[i] + ws[j]] = 1;
            }
        }
        for (int i = 0; i < wCount; i++) {
            dp[ws[i]] = 1;
        }
        for (int i = 2; i <= jCount; i++) {
            for (int j = 1; j <= i/2; j++) {
                if(dp[i-j] == 0 || dp[j] == 0) {
                    continue;
                }
                final int next = dp[j] + dp[i - j];
                if(dp[i] == 0) {
                    dp[i] = next;
                }
                dp[i] = Math.min(dp[i], next);
            }
        }

        if(dp[jCount] == 0) {
            sb.append(-1);
        }else {
            sb.append(dp[jCount]);
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
