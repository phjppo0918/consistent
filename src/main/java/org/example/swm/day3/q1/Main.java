package org.example.swm.day3.q1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int size = Integer.parseInt(st.nextToken());

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> dp = new ArrayList<>();

        dp.add(arr[0]);

        for (int i = 1; i < size; i++) {
            if(arr[i] > dp.get(dp.size() - 1)) {
                dp.add(arr[i]);
            }else {
                for (int j = 0; j < dp.size(); j++) {
                    if(dp.get(j) >= arr[i]) {
                        dp.set(j, arr[i]);
                        break;
                    }
                }
            }
        }

        sb.append(dp.size());

        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
