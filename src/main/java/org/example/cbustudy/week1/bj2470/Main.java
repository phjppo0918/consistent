package org.example.cbustudy.week1.bj2470;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int next = arr[i];
            if(next < 0) {
                minus.add(next);
            }else {
                plus.add(next);
            }
        }
        minus.sort(Collections.reverseOrder());
        Collections.sort(plus);

        int min = Integer.MAX_VALUE;
        int minM = 0;
        int minP = 0;
        if(minus.size() >= 2) {
            final int sum = Math.abs(minus.get(0) + minus.get(1));
            if(min > sum) {
                min = sum;
                minM = minus.get(1);
                minP = minus.get(0);
            }
        }
        if(plus.size() >= 2) {
            final int sum = Math.abs(plus.get(0) + plus.get(1));
            if(min > sum) {
                min = sum;
                minM = plus.get(0);
                minP = plus.get(1);
            }
        }

        int mPivot = 0;
        int pPivot = 0;

        while (mPivot < minus.size() && pPivot < plus.size()) {
            int mNext = minus.get(mPivot);
            int pNext = plus.get(pPivot);

            int sum = mNext + pNext;

            if(min >= Math.abs(sum)) {
                min = Math.abs(sum);
                minM = mNext;
                minP = pNext;
            }

            if(sum > 0) {
                mPivot++;
            }else if(sum < 0) {
                pPivot++;
            }
            else {
                break;
            }
        }


        sb.append(minM).append(" ").append(minP);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
