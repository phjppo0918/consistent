package org.example.swm.day14.bj14226;

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

        final int MAX = 2500;
        int[] dp = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            dp[i] = i;
        }

        for (int i = 6; i < MAX; i+=2) {
            int hubo = dp[i/2] + 2;
            if(dp[i] >= hubo) {
                dp[i] = hubo;
                int next = hubo + 2;
                int pivot = 2;
                while (i*pivot < MAX) {
                    dp[i * pivot] =  Math.min(dp[i * pivot], next);
                    next +=1;
                    pivot++;
                }
            }
            if(dp[i-1] > dp[i] + 1) {
                int j = i-1;
                dp[j] = dp[i] + 2;
                int next = dp[j] + 1;
                int pivot = 2;

                while (j*pivot < MAX) {
                    dp[j * pivot] =  Math.min(dp[j * pivot], next);
                    next +=1;
                    pivot++;
                }
            }

            int pivot = 2;
            int next = dp[i] + 2;
            while (i * pivot < MAX) {
                dp[i * pivot] = Math.min(next, dp[i * pivot]);
                next += 1;
                pivot++;
            }
        }
        sb.append(dp[Integer.parseInt(st.nextToken())]);


        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
