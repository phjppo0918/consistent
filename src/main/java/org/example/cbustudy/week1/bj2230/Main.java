package org.example.cbustudy.week1.bj2230;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int targetGap = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        int ans = Integer.MAX_VALUE;
        Collections.sort(arr);
        int[] gap = new int[arr.size()-1];
        for (int i = 0; i < arr.size()-1; i++) {
            gap[i] = arr.get(i + 1) - arr.get(i);
        }

        for (int i = 0; i < gap.length; i++){
            int total = 0;
            for (int j = i; j < gap.length; j++) {
                total += gap[j];

                if(total >= targetGap) {
                    ans = Math.min(ans, total);
                    break;
                }
            }

        }

        sb.append(ans);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
