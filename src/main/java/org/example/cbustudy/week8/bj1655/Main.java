package org.example.cbustudy.week8.bj1655;

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

        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();

        int size = Integer.parseInt(st.nextToken());
        //처음값
        int next = Integer.parseInt(br.readLine());
        maxQueue.add(next);
        sb.append(next).append("\n");

        for (int i = 1; i < size; i++) {
            next = Integer.parseInt(br.readLine());
            if (maxQueue.size() != minQueue.size()) {
                minQueue.add(next);
            }else {
                maxQueue.add(next);
            }
            if(maxQueue.peek() > minQueue.peek()) {
                int temp = minQueue.poll();
                minQueue.add(maxQueue.poll());
                maxQueue.add(temp);
            }

            sb.append(maxQueue.peek()).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
