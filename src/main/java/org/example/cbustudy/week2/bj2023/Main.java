package org.example.cbustudy.week2.bj2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> answer = new ArrayList<>();
    static int jari;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        jari = Integer.parseInt(st.nextToken());

        backTracking(2);
        backTracking(3);
        backTracking(5);
        backTracking(7);

        answer.forEach(i -> sb.append(i).append("\n"));


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int num) {
        if ((num + "").length() == jari) {
            answer.add(num);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int next = num * 10 + i;
            if (isSosu(next)) {
                backTracking(next);
            }
        }
    }

    static boolean isSosu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
