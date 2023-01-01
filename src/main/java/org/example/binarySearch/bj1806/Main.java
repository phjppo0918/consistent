package org.example.binarySearch.bj1806;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int targetSum = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lPivot = 0;
        int rPivot = 0;
        int minSize = Integer.MAX_VALUE;
        int resentSum = arr[lPivot];

        while (lPivot <= rPivot) {
            if(resentSum >= targetSum) {
                minSize = Math.min(minSize, rPivot - lPivot + 1);
                resentSum -= arr[lPivot];
                lPivot++;
            }else {
                rPivot++;
                if(rPivot >= size) {
                    break;
                }
                resentSum += arr[rPivot];
            }
        }
        if(minSize == Integer.MAX_VALUE) {
            minSize = 0;
        }
        result.append(minSize);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
