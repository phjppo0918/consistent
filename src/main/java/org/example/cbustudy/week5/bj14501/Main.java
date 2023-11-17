package org.example.cbustudy.week5.bj14501;

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

        int day = Integer.parseInt(st.nextToken());

        int[] dp = new int[day + 1 + 100];
        int[] end = new int[day + 1];
        int[] money = new int[day + 1];


        for (int i = 1; i <= day; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            end[i] = i + e - 1;
            money[i] = m;
        }
        int max = 0;

        for (int i = day; i > 0; i--) {
            if (end[i] > day) {
                dp[i] =max;
                continue;
            }

           dp[i] = money[i] + dp[end[i] + 1];

            for (int j = i + 1; j <= end[i] ; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            max = Math.max(max, dp[i]);
        }

        sb.append(max);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
