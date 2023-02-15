package org.example.binarySearch.bj2295;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(br.readLine());

        int[] arr= new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }
        int answer = 0;

        check:
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if(sum.contains(arr[i] - arr[j])) {
                    answer = arr[i];
                    break check;
                }
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
