package org.example.cbustudy.week8.bj9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] graph;
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        graph = new int[size];

        sb.append(back(0));


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int back(int dep) {
        if (dep == size) {
            return 1;
        }
        int answer = 0;

        for (int i = 1; i <= size; i++) {
            boolean isCan = true;
            for (int j = dep - 1; j >= 0; j--) {
                if (graph[j] == i || dep - j == Math.abs(i - graph[j])) {
                    isCan = false;
                    break;
                }
            }
            if (!isCan) {
                continue;
            }
            graph[dep] = i;
            answer += back(dep + 1);
            graph[dep] = 0;
        }

        return answer;
    }
}
