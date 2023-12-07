package org.example.cbustudy.week7.bj11689;

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


        long num = Long.parseLong(st.nextToken());
        long result = num;

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                result = result - result / i;
                while (num %i == 0) {
                    num/=i;
                }
            }
        }

        if(num > 1) {
            result = result - result / num;
        }
        sb.append(result);

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
