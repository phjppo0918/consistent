package org.example.cbustudy.week5.bj13998;

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
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] ldp = new int[size];
        int[] rdp = new int[size];

        ldp[0] = num[0];
        rdp[size-1] = num[size-1];

        int answer = num[0];
        for (int i = 1; i < size; i++) {
            ldp[i] = Math.max(num[i], ldp[i-1] + num[i]);
            answer = Math.max(ldp[i], answer);
        }
        for (int i = size-2; i >=0 ; i--) {
            rdp[i] = Math.max(num[i], rdp[i+1] + num[i]);
            answer = Math.max(rdp[i], answer);
        }

        for (int i = 1; i <size-1; i++) {
            answer = Math.max(answer, ldp[i-1] + rdp[i+1]);
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
