package org.example.cbustudy.week3.bj2343;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int boxSize;
    static int[] nums;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken());
        boxSize = Integer.parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        search();
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static void search() {
        int lPiv = 1;
        int rPiv = 1_000_000_000;

        while (lPiv <= rPiv) {
            int mid = (rPiv - lPiv) / 2 + lPiv;

            if (canInsert(mid)) {
                answer = mid;
                rPiv = mid - 1;
            }else {
                lPiv = mid + 1;
            }
        }
    }

    private static boolean canInsert(int mid) {
        int temp = 0;
        int reCount = 1;
        for (int num : nums) {
            if (temp + num > mid) {
                temp = 0;
                reCount++;
                if (reCount > boxSize || num > mid) {
                    return false;
                }
            }
            temp += num;
        }

        return true;
    }
}
