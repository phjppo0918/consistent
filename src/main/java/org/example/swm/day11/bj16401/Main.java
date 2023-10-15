package org.example.swm.day11.bj16401;

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

        int member = Integer.parseInt(st.nextToken());
        int cSize = Integer.parseInt(st.nextToken());

        final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();


        int startPivot = 0;
        int answer = 0;
        int endPivot = array[cSize - 1];
        while (startPivot <= endPivot) {
            int center = (startPivot + endPivot + 1) / 2;

            if(center == 0) {
                answer = 0;
                break;
            }

            int count = 0;

            for (int i = 0; i < cSize; i++) {
                count += array[i]/center;
            }

            if(count >= member) {
                answer = center;
                startPivot = center+1;
            }else {
                endPivot = center-1;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
