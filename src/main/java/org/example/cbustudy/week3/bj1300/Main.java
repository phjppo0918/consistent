package org.example.cbustudy.week3.bj1300;

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

        long size =  Long.parseLong(st.nextToken());
        final long target = Long.parseLong(br.readLine());

        long lPiv = 1;
        long rPiv = size * size;
        long answer = 0;

        while (lPiv <= rPiv) {
            long mid = (rPiv - lPiv) / 2 + lPiv;
            long midIndex = 0;
            for (int i = 1; i <= size; i++) {
                midIndex += Math.min(size, mid / i);
            }


            if (midIndex >= target) {
                answer = mid;
                rPiv = mid - 1;
            } else {
                lPiv = mid + 1;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
