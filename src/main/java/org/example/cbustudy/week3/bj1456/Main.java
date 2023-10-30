package org.example.cbustudy.week3.bj1456;

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

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());


        final int MAX_NUM = 20_000_001;
        boolean[] isSosu = new boolean[MAX_NUM];
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;
        long answer = 0;
        for (int i = 2; i < MAX_NUM; i++) {
            if (isSosu[i]) {
                for (int j = 2; j * i < MAX_NUM; j++) {
                    isSosu[i * j] = false;
                }

                double temp = i;

                while (i < start/temp) {
                    temp *= i;
                }
                while (i <= end/temp) {
                    answer++;
                    temp *= i;
                }
            }
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
