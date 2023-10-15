package org.example.dbn.bj1764;

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

        int noListenSize = Integer.parseInt(st.nextToken());
        int noLookSize = Integer.parseInt(st.nextToken());
        Set<String> noListens = new HashSet<>();

        Queue<String> answer = new PriorityQueue<>();

        for (int i = 0; i < noListenSize; i++) {
            noListens.add(br.readLine());
        }
        for (int i = 0; i < noLookSize; i++) {
            String noLook = br.readLine();
            if(noListens.contains(noLook)) {
                answer.add(noLook);
            }
        }
        sb.append(answer.size()).append("\n");
        while (!answer.isEmpty()) {
            sb.append(answer.poll()).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
