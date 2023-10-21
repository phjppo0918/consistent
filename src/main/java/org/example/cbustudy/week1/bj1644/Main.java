package org.example.cbustudy.week1.bj1644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());

        final int MAX_NUM = 4_000_000;

        boolean[] isSosu = new boolean[MAX_NUM + 1];
        List<Integer> sosu = new ArrayList<>();
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;
        for (int i = 2; i <= MAX_NUM; i++) {
            if (isSosu[i]) {
                sosu.add(i);
                for (int j = 2; j * i <= MAX_NUM; j++) {
                    isSosu[i*j] = false;
                }
            }
        }
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        sum.add(sosu.get(0));
        for (int i = 1; i < sosu.size(); i++) {
            sum.add(sosu.get(i) + sum.get(i));
        }

        int count = 0;
        int lPivot = 0;
        int rPivot = 1;

        while (lPivot < sum.size() && rPivot < sum.size()) {
            int total = sum.get(rPivot) - sum.get(lPivot);

            if (total == target) {
                count++;
            }

            if(total > target) {
                lPivot++;
            }else {
                rPivot++;
            }
        }


        sb.append(count);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
