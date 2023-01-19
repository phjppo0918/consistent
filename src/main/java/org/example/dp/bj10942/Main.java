package org.example.dp.bj10942;

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

        int numCount = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean[][] dp = new boolean[numCount + 1][numCount + 1];
        for (int gap = 0; gap <= numCount; gap++) {
            for (int i = 0; i < numCount; i++) {
                int rPivot = i + gap;
                if(rPivot >= numCount) {
                    break;
                }
                if(nums[i] == nums[rPivot]) {
                    if(i + 1 >= rPivot - 1 || dp[i + 1][rPivot - 1]) {
                        dp[i][rPivot] = true;
                    }
                }
            }
        }

        int questCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < questCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(dp[start-1][end-1]) {
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
