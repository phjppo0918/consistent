package org.example.swm.day11.bj2302;

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

        int size = Integer.parseInt(st.nextToken());
        int fixCount = Integer.parseInt(br.readLine());
        int[] line = new int[size + 1];
        int[] dp = new int[size + 1];
        boolean[] fix = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            line[i] = i;
        }

        for (int i = 0; i < fixCount; i++) {
            fix[Integer.parseInt(br.readLine())] = true;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= size; i++) {
            dp[i] = dp[i-1];
            if(fix[i]) {
                continue;
            }

            if(!fix[i-1]) {
                dp[i] += dp[i-2];
            }
        }

        sb.append(dp[size]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
