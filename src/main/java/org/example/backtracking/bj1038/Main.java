package org.example.backtracking.bj1038;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        final int MAX = 1022;
        if(n <= 10) {
            result.append(n);
        }else if(n > MAX) {
            result.append(-1);
        }else {
            for (int i = 1; i < 10; i++) {
                dfs(i);
            }
            Collections.sort(list);
            result.append(list.get(n-1));
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(long num) {
        list.add(num);
        int nextOne = (int) (num%10 - 1);
        for (int i = nextOne; i >= 0; i--) {
            dfs(num * 10 + i);
        }

    }
}
