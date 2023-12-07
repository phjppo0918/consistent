package org.example.cbustudy.week7.bj1256;

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


        int aCount = Integer.parseInt(st.nextToken());
        int zCount = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        final int MAX = 204;
        int[][] dp = new int[MAX][MAX];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    if (dp[i][j] > 1000000000) {
                        dp[i][j] = 1000000001;
                    }
                }
            }
        }
        if (dp[aCount + zCount][zCount] < target) {
            sb.append(-1);
        } else {
            while (!(aCount == 0 && zCount == 0)) {

                if (dp[aCount - 1 + zCount][zCount] >= target) {
                    sb.append('a');
                    aCount--;
                } else {
                    sb.append("z");
                    target = target - dp[aCount - 1 + zCount][zCount];
                    zCount--;
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
