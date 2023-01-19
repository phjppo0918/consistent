package org.example.dp.bj1509;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char[] chars = br.readLine().toCharArray();
        boolean[][] dp = new boolean[chars.length + 1][chars.length + 1];
        for (int gap = 0; gap <= chars.length; gap++) {
            for (int i = 0; i < chars.length; i++) {
                int rPivot = i + gap;
                if (rPivot >= chars.length) {
                    break;
                }
                if (chars[i] == chars[rPivot]) {
                    if (i + 1 >= rPivot - 1 || dp[i + 1][rPivot - 1]) {
                        dp[i][rPivot] = true;
                    }
                }
            }
        }
        int[] answerDP = new int[chars.length + 1];

        for (int i = 1; i < answerDP.length; i++) {
            answerDP[i] = answerDP[i-1] + 1;
            for (int j = 1; j < i; j++) {
                if (dp[j-1][i-1]) {
                    answerDP[i] = Math.min(answerDP[j-1] + 1,  answerDP[i]);
                }
            }
        }
        sb.append(answerDP[chars.length]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
