package org.example.swm.day11.bj1300;

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
        int targetIndex = Integer.parseInt(br.readLine());

        long startPivot = 0;
        long endPivot = 10_000_000_000L;

        while (startPivot < endPivot) {
            long center = (endPivot+startPivot)/2;
            long index = 0;
            for (int i = 1; i <= size; i++) {
                index += Math.min(center/i, size);
            }

            if(index < targetIndex) {
                startPivot = center + 1;
            }else {
                endPivot = center;
            }
        }
        sb.append(endPivot);
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
