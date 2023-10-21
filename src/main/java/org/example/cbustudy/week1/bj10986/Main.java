package org.example.cbustudy.week1.bj10986;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sums = new long[arr.length + 1];

        for (int i = 0; i < size; i++) {
            sums[i+1] = (arr[i] + sums[i])%target;
        }
        long count = 0;

        long[] deCount = new long[target];
        for (int i = 1; i <= size; i++) {
            deCount[(int)sums[i]]++;
        }
        count += deCount[0];
        for (int i = 0; i < target; i++) {
            count += combi(deCount[i]);
        }
        sb.append(count);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static long combi(long n) {
        return n * (n-1) / 2;
    }
}
