package org.example.cbustudy.week3.bj1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        final int MAX_NUM = 1_000_001;
        boolean[] isSosu = new boolean[MAX_NUM];
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;
        Queue<Integer> sosu = new LinkedList<>();
        for (int i = 2; i < MAX_NUM; i++) {
            if(isSosu[i]) {
                sosu.add(i);
                for (int j = 2; j * i < MAX_NUM; j++) {
                    isSosu[i * j] = false;
                }
            }
        }

        while (sosu.peek() < start) {
            sosu.poll();
        }

        while (sosu.peek() <= end) {
            sb.append(sosu.poll()).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
