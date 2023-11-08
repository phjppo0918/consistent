package org.example.cbustudy.week4.bj1389;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int memberSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int[][] graph = new int[memberSize + 1][memberSize + 1];

        for (int i = 0; i <= memberSize; i++) {
            for (int j = 0; j <= memberSize; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= memberSize; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            graph[m1][m2] = 1;
            graph[m2][m1] = 1;
        }

        for (int mid = 1; mid <= memberSize; mid++) {
            for (int start = 1; start <= memberSize; start++) {
                for (int end = 1; end <= memberSize; end++) {
                    if(graph[start][mid] != Integer.MAX_VALUE && graph[mid][end] != Integer.MAX_VALUE) {
                        graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                        graph[end][start] = graph[start][end];
                    }
                }
            }
        }

        int minScore = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= memberSize ; i++) {
            int total = 0;
            for (int j = 1; j <= memberSize ; j++) {
                total += graph[i][j];
            }
            if(total < minScore) {
                minScore = total;
                answer = i;
            }
        }

        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
