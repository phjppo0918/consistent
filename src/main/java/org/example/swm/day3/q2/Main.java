package org.example.swm.day3.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Pipe dp[][] = new Pipe[size + 1][size + 1];
        int graph[][] = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = new Pipe();
            }
        }

        dp[0][1].add(Status.GARO, 1);


        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                //가로
                if(graph[i+1][j] == 1) {

                }
                //세로

                //대각
            }
        }
        sb.append(dp[size - 1][size - 1]);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int getCount(int[][] dp, int x, int y) {
        int result = 0;
        if (x > 0) {
            result += dp[x - 1][y];
        }

        if (y > 0) {
            result += dp[x][y - 1];
        }

        if (x > 0 && y > 0) {
            result += dp[x - 1][y - 1];
        }

        return result;
    }
}

class Pipe {
    Map<Status, Integer> map = new EnumMap<>(Status.class);

    public Pipe() {
        map.put(Status.GARO, 0);
        map.put(Status.SERO, 0);
        map.put(Status.DEGAK, 0);
    }

    public void add(final Status status, int count) {
       map.put(status, map.get(status) + count);
    }
}

enum Status {
    GARO,
    SERO,
    DEGAK;
}
