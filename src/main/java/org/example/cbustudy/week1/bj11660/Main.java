package org.example.cbustudy.week1.bj11660;

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

        int boxSize = Integer.parseInt(st.nextToken());
        int operSize = Integer.parseInt(st.nextToken());

        int[][] arr = new int[boxSize][boxSize];
        int[][] sums = new int[boxSize + 1][boxSize + 1];
        for (int i = 0; i < boxSize; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                sums[i+1][j+1] = arr[i][j] + sums[i][j+1] + sums[i+1][j] - sums[i][j];
            }
        }

        for (int i = 0; i < operSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            final int result = sums[endY][endX] - sums[endY][startX - 1] - sums[startY - 1][endX] + sums[startY - 1][startX - 1];

            sb.append(result).append("\n");
        }



        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
