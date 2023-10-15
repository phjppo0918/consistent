package org.example.greedy.bj11497;

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

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {

            final int tCount = Integer.parseInt(br.readLine());

            int[] t = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int left = t[t.length - 1];
            int right = t[t.length - 2];
            int max = left - right;
            for (int j = t.length - 3; j >= 0; j--) {
                int next = t[j];
                if(left > right) {
                    max = Math.max(max, left - next);
                    left = next;
                }else {
                    max = Math.max(max, right - next);
                    right = next;
                }
            }

            max = Math.max(max, Math.abs(left - right));
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
