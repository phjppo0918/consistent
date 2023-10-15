package org.example.hock.bj13415;

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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int round = Integer.parseInt(br.readLine());
        Stack<Short> stack = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            stack.push((short) arr[i]);
        }

        for (int i = 0; i < round; i++) {
            st = new StringTokenizer(br.readLine());
            int ascIndex = Integer.parseInt(st.nextToken()) ;
            int descIndex = Integer.parseInt(st.nextToken()) ;
            Queue<Short> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < ascIndex; j++) {
                queue.add(stack.pop());
            }
            while (!queue.isEmpty()) {
                stack.add(queue.poll());
            }
            queue = new PriorityQueue<>();
            for (int j = 0; j < descIndex; j++) {
                queue.add(stack.pop());
            }
            while (!queue.isEmpty()) {
                stack.add(queue.poll());
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
