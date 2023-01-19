package org.example.dp.bj9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line1 = br.readLine().toCharArray();
        char[] line2 = br.readLine().toCharArray();

        int[][] dp = new int[line1.length + 1][line2.length + 1];

        List<Character> ansReverse = new ArrayList<>();
        for (int i = 1; i <= line1.length; i++) {
            for (int j = 1; j <= line2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(line1[i-1] == line2[j-1]) {
                    dp[i][j] = dp[i -1][j - 1] + 1;
                }
            }
        }
        int answer = dp[line1.length][line2.length];
        int xPivot = line1.length;
        int yPivot = line2.length;
        while (dp[xPivot][yPivot] != 0) {
            if(dp[xPivot][yPivot] == dp[xPivot-1][yPivot]) {
                xPivot--;
            }else if(dp[xPivot][yPivot] == dp[xPivot][yPivot-1]) {
                yPivot--;
            }else {
                ansReverse.add(line1[xPivot-1]);
                xPivot--;
                yPivot--;
            }

        }
        Collections.reverse(ansReverse);
        sb.append(answer).append("\n");
        ansReverse.forEach(sb::append);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
