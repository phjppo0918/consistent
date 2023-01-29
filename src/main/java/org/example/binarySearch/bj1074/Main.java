package org.example.binarySearch.bj1074;

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

        int size = Integer.parseInt(st.nextToken());
        int colFinishLocation = Integer.parseInt(st.nextToken());
        int rowFinishLocation = Integer.parseInt(st.nextToken());
        int rowLocationPivot = 0;
        int colLocationPivot = 0;
        long answer = 0;
        int boardSize = (int) Math.pow(2, size);
        int gapPivot = boardSize / 2;
        while (rowLocationPivot != rowFinishLocation) {
            while (rowLocationPivot + gapPivot > rowFinishLocation) {
                gapPivot /=2;
            }
            answer += (long) gapPivot * gapPivot;
            rowLocationPivot += gapPivot;
        }
        gapPivot = boardSize / 2;
        while (colLocationPivot != colFinishLocation) {
            while (colLocationPivot + gapPivot > colFinishLocation) {
                gapPivot /=2;
            }
            answer += (long) gapPivot * gapPivot * 2;
            colLocationPivot += gapPivot;
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
