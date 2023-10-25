package org.example.cbustudy.week2.bj11286;

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
        Queue<Integer> nums = new PriorityQueue<>(((i, j) -> {
            if (Math.abs(i) == Math.abs(j)) {
                return i - j;
            }
            return Math.abs(i) - Math.abs(j);
        }));

        for (int i = 0; i < size; i++) {
            final int next = Integer.parseInt(br.readLine());
            if (next == 0) {
                if (nums.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(nums.poll()).append("\n");
                }
                continue;
            }
            nums.add(next);
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

