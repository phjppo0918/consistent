package org.example.cbustudy.week7.bj1947;

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

        final int MAX = 1000001;
        int member = Integer.parseInt(st.nextToken());
        long div = 1000000000;
        long dp[] = new long[MAX];
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<=member; i++){
            dp[i] = (i-1)*(dp[i-1]+dp[i-2])%div;
        }
        sb.append(dp[member]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
