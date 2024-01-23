package org.example.cbustudy.week10.bj1890;

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

        int size = Integer.parseInt(st.nextToken());
        int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[size][size];
        dp[0][0] = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(dp[i][j] == 0 || graph[i][j] == 0) {
                    continue;
                }
                int gap = graph[i][j];
                if (i + gap < size) {
                    dp[i + gap][j] += dp[i][j];
                }
                if (j + gap < size) {
                    dp[i][j + gap] += dp[i][j];
                }
            }
        }

        sb.append(dp[size - 1][size - 1]);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
