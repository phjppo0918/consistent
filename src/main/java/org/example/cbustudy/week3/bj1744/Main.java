package org.example.cbustudy.week3.bj1744;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        Queue<Long> plus = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Long> minus = new PriorityQueue<>();

        long answer = 0;
        for (int i = 0; i < size; i++) {
            final long next = Long.parseLong(br.readLine());
            if(next == 1) {
                answer++;
                continue;
            }
            if (next > 0) {
                plus.add(next);
            } else {
                minus.add(next);
            }
        }

        while (plus.size() > 1) {
            answer += (plus.poll() * plus.poll());
        }
        if (!plus.isEmpty()) {
            answer += plus.poll();
        }

        while (minus.size() > 1) {
            answer += (minus.poll() * minus.poll());
        }
        if (!minus.isEmpty()) {
            answer += minus.poll();
        }

        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
