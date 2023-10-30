package org.example.cbustudy.week3.bj1920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int findSize = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(
                i -> {
                    if(search(i)) {
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    sb.append("\n");
                }
        );


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean search(int target) {
        int lPiv = 0;
        int rPiv = arr.length -1;

        while (lPiv <= rPiv) {
            int mid = (rPiv - lPiv)/2 + lPiv;
            final int value = arr[mid];
            if(value == target) {
                return true;
            }else if(value > target) {
                rPiv = mid-1;
            }else {
                lPiv = mid+1;
            }
        }

        return false;
    }
}
