package org.example.cbustudy.week2.bj2750;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while (target > 1) {
            queue.poll();
            target--;
        }
        sb.append(queue.poll());

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
