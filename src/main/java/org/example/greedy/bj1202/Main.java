package org.example.greedy.bj1202;

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
        int jewelSize = Integer.parseInt(st.nextToken());
        int bagSize = Integer.parseInt(st.nextToken());
        Queue<Jewel> queue = new PriorityQueue<>();
        Queue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> bag = new PriorityQueue<>();
        for (int i = 0; i < jewelSize; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new Jewel(weight, value));
        }
        for (int i = 0; i < bagSize; i++) {
            int weight = Integer.parseInt(br.readLine());
            bag.add(weight);
        }
        long answer = 0;
        while (!bag.isEmpty()) {
            Integer nowBag = bag.poll();
            while (!queue.isEmpty() && queue.peek().weight <= nowBag) {
                values.add(queue.poll().value);
            }
            if(!values.isEmpty()) {
                answer += values.poll();
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        if (weight == o.weight) {
            return o.value - value;
        }
        return weight - o.weight;
    }
}

