package org.example.cbustudy.week7.bj1934;

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
    
        int caseSize = Integer.parseInt(st.nextToken());

        for (int i = 0; i < caseSize; i++) {

            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            int t1 = num1;
            int t2 = num2;

            while (t2 % t1 != 0) {
                int temp = t2 % t1;
                t2 = t1;
                t1 = temp;
            }

            sb.append(num1 * num2 /t1).append("\n");
        }

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
