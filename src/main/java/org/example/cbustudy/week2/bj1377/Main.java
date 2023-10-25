package org.example.cbustudy.week2.bj1377;

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
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> indexs = new HashMap<>();
        for (int i = 0; i < size; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> copy = new ArrayList<>(nums);
        Collections.sort(copy);
        for (int i = 0; i < size; i++) {
            indexs.put(copy.get(i), i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
           max = Math.max(max, i - indexs.get(nums.get(i)));
        }
        sb.append(max + 1);



        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
