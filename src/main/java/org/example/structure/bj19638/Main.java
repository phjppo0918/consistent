package org.example.structure.bj19638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int bigmanSize = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int magicCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < bigmanSize; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        String answer = "YES";
        int use = 0;
        while (true) {
            int target = pq.poll();
            if(target < centiHeight) {
                break;
            }
            if(magicCount == use) {
                answer = "NO";
                pq.add(target);
                break;
            }

            use++;
            if(target!= 1) {
                target/=2;
            }
            pq.add(target);
        }

        sb.append(answer).append('\n');
        if(answer.equals("NO")) {
            sb.append(pq.poll());
        }else {
            sb.append(use);
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
