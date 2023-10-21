package org.example.cbustudy.week1.bj3020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int amount = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] topCount = new int[height + 1];
        int[] botCount = new int[height + 1];

        for (int i = 0; i < amount / 2; i++) {
            final int botNext = Integer.parseInt(br.readLine());
            final int topNext = Integer.parseInt(br.readLine());
            botCount[botNext]++;
            topCount[height - topNext + 1]++;
        }
        int[] topSum = new int[height + 1];
        int[] botSum = new int[height + 2];

        for (int i = height; i >= 1; i--) {
            botSum[i] = botCount[i] + botSum[i + 1];
        }
        for (int i = 1; i <= height; i++) {
            topSum[i] = topCount[i] + topSum[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= height; i++) {
            int next = topSum[i] + botSum[i];
            if(min > next) {
                count = 1;
                min = next;
            }else if(min == next) {
                count++;
            }
        }

        sb.append(min).append(" ").append(count);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
