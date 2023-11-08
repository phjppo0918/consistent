package org.example.cbustudy.week4.bj11403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[][] graph = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int mid = 1; mid<= size; mid++) {
            for (int start = 1; start <=size ; start++) {
                for (int end = 1; end <= size; end++) {
                    if(graph[start][mid] == 1 && graph[mid][end] == 1) {
                        graph[start][end] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <=size; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
