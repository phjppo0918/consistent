package greedy.bj1744;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSize = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        long answer = 0;
        for (int i = 0; i < numSize; i++) {
            int temp = Integer.parseInt(br.readLine());


            if(temp > 0) {
                if(temp == 1) {
                    answer++;
                    continue;
                }
                plusPQ.add(temp);
            }else {
                minusPQ.add(temp);
            }
        }

        while (plusPQ.size() > 1) {
            answer += (plusPQ.poll() * plusPQ.poll());
        }

        while (minusPQ.size() > 1) {
            answer += (minusPQ.poll() * minusPQ.poll());
        }

        if(!plusPQ.isEmpty()) {
            answer += plusPQ.poll();
        }

        if(!minusPQ.isEmpty()) {
            answer += minusPQ.poll();
        }

        result.append(answer);
        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
