package org.example.cbustudy.week7.bj11051;

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


        final int max = 1003;
        long[][] arr = new long[max][max];

        for (int i = 0; i < max; i++) {
            arr[i][0] = 1;
            arr[i][1] = 1;
            arr[i][i] = 1;
        }

        for (int i = 2; i < max; i++) {
            for (int j = 2; j < max; j++) {
                if(arr[i][j] != 0) {
                    break;
                }
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1])%10_007;
            }
        }

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        sb.append(arr[n1+1][n2+1]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
