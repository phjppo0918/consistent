package org.example.cbustudy.week3.bj2512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] moneys = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        final int targetMoney = Integer.parseInt(br.readLine());

        int lPiv = 0;
        int rPiv = moneys[size - 1];
        int answer = 0;

        while (lPiv <= rPiv) {
            int total = 0;
            int mid = (rPiv - lPiv)/2 + lPiv;

            for (int m : moneys) {
                total += Math.min(m, mid);
            }

            if(total > targetMoney) {
                rPiv = mid - 1;
            }else {
                answer = mid;
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
