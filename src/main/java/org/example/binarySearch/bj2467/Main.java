package org.example.binarySearch.bj2467;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sPivot = 0;
        int ePivot = size - 1;
        long minGap = Long.MAX_VALUE;
        int bestLeft = sPivot;
        int bestRight = ePivot;
        for (int i = 0; i < size - 1; i++) {
            long sumValue = arr[i] + arr[i+1];
            long resentGap = Math.abs(sumValue);
            if (resentGap < minGap) {
                minGap = resentGap;
                bestLeft = i;
                bestRight = i+1;
            }
        }

        while (sPivot != ePivot) {
            long sumValue = arr[sPivot] + arr[ePivot];
            long resentGap = Math.abs(sumValue);
            if (resentGap < minGap) {
                minGap = resentGap;
                bestLeft = sPivot;
                bestRight = ePivot;
            }

            if(sumValue >= 0) {
                ePivot--;
            }else {
                sPivot++;
            }
        }
        result.append(arr[bestLeft]).append(" ").append(arr[bestRight]);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
