package org.example.cbustudy.week1.bj2018;

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

        int num = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 1; i < num; i++) {
            int sum = 0;
            for (int j = i; j < num; j++) {
                sum += j;
                if(sum >= num) {
                    break;
                }
            }

            if(sum == num) {
                count++;
            }
        }
        sb.append(count + 1);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
