package org.example.cbustudy.week4.bj11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(br.readLine());

        long[][] value = new long[citySize + 1][citySize + 1];

        for (int i = 0; i <=citySize ; i++) {
            Arrays.fill(value[i], Long.MAX_VALUE);
        }
        for (int i = 1; i <= citySize; i++) {
            value[i][i] = 0;
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            value[start][end] = Math.min(v, value[start][end]);
        }

        for (int mid = 1; mid <= citySize ; mid++) {
            for (int start = 1; start <= citySize; start++) {
                for (int end = 1; end <= citySize; end++) {
                    if( value[start][mid] != Long.MAX_VALUE && value[mid][end] != Long.MAX_VALUE) {
                        value[start][end] = Long.min(value[start][end], value[start][mid] + value[mid][end]);
                    }
                }
            }
        }

        for (int i = 1; i <= citySize ; i++) {
            for (int j = 1; j <= citySize; j++) {
                if(value[i][j] == Long.MAX_VALUE) {
                    value[i][j] = 0;
                }

                sb.append(value[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
