package org.example.swm.day2.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int size = Integer.parseInt(st.nextToken());

        final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dp[] = new int[size + 1];

        if(size == 1) {
            sb.append(0);
        }else if(size == 2) {
            sb.append(Math.abs(array[0] - array[1]));
        }else {
            dp[1] = Math.abs(array[0] - array[1]);


        }

        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
