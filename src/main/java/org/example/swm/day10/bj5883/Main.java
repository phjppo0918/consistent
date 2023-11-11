package org.example.swm.day10.bj5883;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        boolean[] has = new boolean[1_000_001];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int num = Integer.parseInt(br.readLine());
            list.add(num);
            has[num] = true;
        }
        int max = 0;

        for (int i = 0; i < 1_000_001; i++) {
            if(!has[i]) {
                continue;
            }
            final int ii = i;
            final int[] array = list.stream().filter(n -> n != ii).mapToInt(n -> n).toArray();
            int head = array[0];
            int count = 1;

            for (int j = 1; j<array.length;j++) {
                int a = array[j];
                if (head == a) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                    head = a;
                }
            }
            max = Math.max(max, count);
        }
        sb.append(max);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
