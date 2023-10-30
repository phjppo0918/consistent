package org.example.cbustudy.week3.bj1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        List<Moim> moims = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            moims.add(new Moim(start, end));
        }

        Collections.sort(moims);
        int time = 0;
        int answer = 0;
        for (int i = 0; i < size; i++) {
            Moim now = moims.get(i);
            if(now.start >= time) {
                time = now.end;
                answer++;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Moim implements Comparable<Moim> {
    int start;
    int end;

    public Moim(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Moim o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }

        return this.end - o.end;
    }
}
