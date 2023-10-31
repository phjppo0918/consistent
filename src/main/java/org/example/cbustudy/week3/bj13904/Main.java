package org.example.cbustudy.week3.bj13904;

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

        Queue<Subject> queue = new PriorityQueue<>();
        Queue<Integer> answer = new PriorityQueue<>();
        int size = Integer.parseInt(st.nextToken());
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            queue.add(new Subject(day, score));
        }
        while (!queue.isEmpty()) {
            final Subject now = queue.poll();
            if(answer.size() < now.dday) {
                answer.add(now.score);
            }else {
                if(answer.peek() < now.score) {
                    answer.poll();
                    answer.add(now.score);
                }
            }
        }
        int ans = 0;
        while (!answer.isEmpty()) {
            ans += answer.poll();
        }
        sb.append(ans);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Subject implements Comparable<Subject> {
    int dday;

    int score;

    public Subject(int dday, int score) {
        this.dday = dday;
        this.score = score;
    }

    @Override
    public int compareTo(Subject s) {
        if(dday == s.dday){
            return  s.score - score;
        }
        return dday - s.dday;
    }
}