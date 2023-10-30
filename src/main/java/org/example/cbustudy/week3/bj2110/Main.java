package org.example.cbustudy.week3.bj2110;

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

        int homeCount = Integer.parseInt(st.nextToken());
        int gongCount = Integer.parseInt(st.nextToken());

        List<Integer> homes = new ArrayList<>();
        homes.add(Integer.parseInt(br.readLine()));

        for (int i = 1; i < homeCount; i++) {
            homes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(homes);
        int lPiv = 1;
        int rPiv = homes.get(homeCount - 1) - homes.get(0) + 1;
        int answer = Integer.MIN_VALUE;

        while (lPiv < rPiv) {
            int mid = (rPiv - lPiv) / 2 + lPiv;
            int count = 1;
            int nowIdx = 0;
            for (int i = 1; i < homeCount; i++) {
                if (homes.get(i) - homes.get(nowIdx) >= mid) {
                    nowIdx = i;
                    count++;
                }
            }
            if (count < gongCount) {
                rPiv = mid;
            } else {
                answer = mid;
                lPiv = mid + 1;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
