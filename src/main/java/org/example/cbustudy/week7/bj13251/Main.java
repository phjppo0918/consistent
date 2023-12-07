package org.example.cbustudy.week7.bj13251;

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

        int cSize = Integer.parseInt(st.nextToken());
        int[] counts = new int[cSize];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cSize; i++) {
            int next = Integer.parseInt(st.nextToken());
            counts[i] = next;
            total += next;
        }

        double prob[] = new double[51];
        double answer = 0;



        final int pickCount = Integer.parseInt(br.readLine());



        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
