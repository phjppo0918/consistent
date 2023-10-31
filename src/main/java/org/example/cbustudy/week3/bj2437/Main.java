package org.example.cbustudy.week3.bj2437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        final int max = 1_000_002;
        boolean[] filter = new boolean[max];
        boolean fin = false;
        int answer = Arrays.stream(nums).sum() + 1;

        for (int n : nums) {
            for (int i = max - n - 1; i > 0; i--) {
                if (filter[i]) {
                    filter[i + n] = true;
                }
            }
            filter[n] = true;
            for (int i = 1; i < n; i++) {
                if (!filter[i]) {
                    answer = i;
                    fin = true;
                    break;
                }
            }
            if (fin) {
                break;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
