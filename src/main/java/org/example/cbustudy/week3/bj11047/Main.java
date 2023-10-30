package org.example.cbustudy.week3.bj11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int targetMoney = Integer.parseInt(st.nextToken());
        int answer = 0;
        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        for (int i = size - 1; i >= 0; i--) {
            final Integer now = coins.get(i);

            answer += targetMoney / now;
            targetMoney %= now;
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
