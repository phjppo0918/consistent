package org.example.greedy.bj9576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int bookCount = Integer.parseInt(st.nextToken());
            boolean[] bookArr = new boolean[bookCount + 1];
            int peopleCount = Integer.parseInt(st.nextToken());
            Queue<Student> students = new PriorityQueue<>();
            for (int j = 0; j < peopleCount; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                students.add(new Student(start, end));
            }
            int count = 0;
            while (!students.isEmpty()) {
                Student student = students.poll();
                for (int j = student.start; j <= student.end; j++) {
                    if(!bookArr[j]) {
                        bookArr[j] = true;
                        count++;
                        break;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Student implements Comparable<Student> {
    int start;
    int end;

    public Student(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Student o) {
        int compare = end - o.end;
        if(compare == 0) {
            compare = o.start - start;
        }
        return compare;
    }
}
