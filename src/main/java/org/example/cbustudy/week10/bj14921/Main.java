package org.example.cbustudy.week10.bj14921;

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

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lPivot = 0;
        int rPivot = arr.length - 1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            final int sum = arr[i] + arr[i + 1];
            if(Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }

        }

        while (lPivot < rPivot) {
            final int sum = arr[lPivot] + arr[rPivot];
            if(Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }

            if (sum > 0) {
                rPivot--;
            } else {
                lPivot++;
            }
        }

        sb.append(min);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
