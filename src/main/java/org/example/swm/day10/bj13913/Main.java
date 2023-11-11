package org.example.swm.day10.bj13913;

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

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        final int MAX_LENGTH = 100_001;
        int[] before = new int[MAX_LENGTH];
        Arrays.fill(before, -1);
        boolean[] visit = new boolean[MAX_LENGTH];
        int[] time = new int[MAX_LENGTH];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            final Integer now = queue.poll();
            if(now == end) {
                break;
            }
            if(now *2 < MAX_LENGTH) {
                int next = now * 2;
                if(!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    before[next] = now;
                    time[next] = time[now] + 1;
                }
            }

            if(now -1 >= 0) {
                int next = now -1;
                if(!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    before[next] = now;
                    time[next] = time[now] + 1;
                }
            }


            if(now +1 < MAX_LENGTH) {
                int next = now + 1;
                if(!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    before[next] = now;
                    time[next] = time[now] + 1;
                }
            }
        }

        if(start == end) {
            sb.append(0).append("\n").append(start);
        }else {
            sb.append(time[end]).append("\n");
            List<Integer> location = new ArrayList<>();
            int now = end;
            while (now != -1) {
                location.add(now);
                now = before[now];
            }

            Collections.reverse(location);
            location.forEach(l -> sb.append(l).append(" "));
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
