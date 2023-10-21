package org.example.cbustudy.week1.bj1253;

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

        int size = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int count = 0;

        for (int i = 0; i < size; i++) {
            int sPivot = 0;
            int ePivot = size - 1;

            while (sPivot < ePivot) {
                int target = arr[i];
                final int sum = arr[sPivot] + arr[ePivot];
                if (sum > target || ePivot == i) {
                    ePivot--;
                } else if (sum < target || sPivot == i) {
                    sPivot++;
                } else {
                    count++;
                    break;
                }

            }
        }


        sb.append(count);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
