package org.example.binarySearch.bj3079;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int tableCount = Integer.parseInt(st.nextToken());
        int memberCount = Integer.parseInt(st.nextToken());
        int[] table = new int[tableCount];
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < tableCount; i++) {
            table[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, table[i]);
        }
        long start = 0;
        long finish = maxTime * 1_000_000_000L;

        long answer = 0;

        while (start <= finish) {
            long mid = (start + finish) / 2;
            long totalTime = 0;
            for(int t : table) {
                totalTime += mid/t;
            }
            if(memberCount <= totalTime) {
                finish = mid - 1;
                answer = mid;
            }else {
                start = mid + 1;
            }
        }
        sb.append(answer);

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
