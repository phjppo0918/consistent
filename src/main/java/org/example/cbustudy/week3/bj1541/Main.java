package org.example.cbustudy.week3.bj1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        final String str = br.readLine();

        final String[] arr = str.split("-");

        List<Integer> nums = new ArrayList<>();

        for(String a : arr) {
            nums.add(Arrays.stream(a.split("\\+")).mapToInt(Integer::parseInt).sum());
        }
        int answer = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            answer -= nums.get(i);
        }

        sb.append(answer);


        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
