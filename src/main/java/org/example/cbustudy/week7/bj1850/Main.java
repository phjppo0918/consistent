package org.example.cbustudy.week7.bj1850;

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

        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());


        if (num1 > num2) {
            long temp = num1;
            num1 = num2;
            num2 = temp;
        }

        long t1 = num1;
        long t2 = num2;

        while (t2 % t1 != 0) {
            long temp = t2 % t1;
            t2 = t1;
            t1 = temp;
        }

        for (long i = 0; i < t1; i++) {
            sb.append(1);
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
