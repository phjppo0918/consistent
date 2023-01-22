package org.example.greedy.bj17615;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int redCount = 0;
        int blueCount = 0;
        for (int i = 0; i < size; i++) {
            if(chars[i] == 'B') {
                blueCount++;
            }else {
                redCount++;
            }
        }
        int count = Integer.MAX_VALUE;
        int headCount = 0;

        // 빨강 좌정렬
        for (int i = 0; i < size; i++) {
            if(chars[i] == 'R') {
                headCount++;
            }else {
                break;
            }
        }
        count = Math.min(count, redCount - headCount);
        headCount = 0;
        // 빨강 우정렬
        for (int i = size - 1; i >= 0; i--) {
            if(chars[i] == 'R') {
                headCount++;
            }else {
                break;
            }
        }
        count = Math.min(count, redCount - headCount);
        headCount = 0;

        // 파랑 좌정렬
        for (int i = 0; i < size; i++) {
            if(chars[i] == 'B') {
                headCount++;
            }else {
                break;
            }
        }
        count = Math.min(count, blueCount - headCount);
        headCount = 0;

        // 파랑 우정렬
        for (int i = size - 1; i >= 0; i--) {
            if(chars[i] == 'B') {
                headCount++;
            }else {
                break;
            }
        }
        count = Math.min(count, blueCount - headCount);
        sb.append(count);
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
