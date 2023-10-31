package org.example.cbustudy.week3.bj2138;

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
        final String start = br.readLine();
        final String t = br.readLine();

        boolean[] planA = new boolean[size];
        boolean[] planB = new boolean[size];
        boolean[] target = new boolean[size];

        for (int i = 0; i < size; i++) {
            planA[i] = start.charAt(i) == '1';
            planB[i] = start.charAt(i) == '1';
            target[i] = t.charAt(i) == '1';
        }
        planB[0] = !planB[0];
        planB[1] = !planB[1];

        int aCount = 0;
        int bCount = 1;

        //AB 끄기
        for (int i = 0; i < size - 2; i++) {
            if (planA[i] != target[i]) {
                planA[i] = !planA[i];
                planA[i + 1] = !planA[i + 1];
                planA[i + 2] = !planA[i + 2];
                aCount++;
            }

            if (planB[i] != target[i]) {
                planB[i] = !planB[i];
                planB[i + 1] = !planB[i + 1];
                planB[i + 2] = !planB[i + 2];
                bCount++;
            }
        }
        //마지막꺼 끄기
        if (planA[size - 2] != target[size - 2] || planA[size - 1] != target[size - 1]) {
            planA[size - 2] = !planA[size - 2];
            planA[size - 1] = !planA[size - 1];
            aCount++;
        }

        if (planB[size - 2] != target[size - 2] || planB[size - 1] != target[size - 1]) {
            planB[size - 2] = !planB[size - 2];
            planB[size - 1] = !planB[size - 1];
            bCount++;
        }
        //일치 불일치 확인
        int answer = Integer.MAX_VALUE;

        boolean canA = true, canB = true;
        for (int i = 0; i < size; i++) {
            if (planA[i] != target[i]) {
                canA = false;
            }
            if (planB[i] != target[i]) {
                canB = false;
            }
        }

        if (canA) {
            answer = aCount;
        }
        if (canB) {
            answer = Integer.min(answer, bCount);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
