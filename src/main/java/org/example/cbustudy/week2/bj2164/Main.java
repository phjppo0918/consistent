package org.example.cbustudy.week2.bj2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        sb.append(queue.poll());

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
