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
        final int MAX = 52;
        int[] counts = new int[MAX];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cSize; i++) {
            int next = Integer.parseInt(st.nextToken());
            counts[i] = next;
            total += next;
        }

        double prob[] = new double[MAX];
        double answer = 0;
        int target = Integer.parseInt(br.readLine());

        for (int i=0;i<cSize;i++) {
            if(counts[i] >= target) {
                prob[i] = 1;
                for (int j = 0; j < target; j++) {
                    prob[i] *= (double)( counts[i] - j) / (total - j);
                }
                answer += prob[i];
            }
        }
        sb.append(answer);



        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
