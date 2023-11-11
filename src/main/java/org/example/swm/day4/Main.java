package org.example.swm.day4;

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

        int targetSize = Integer.parseInt(st.nextToken());
        int dataSize = Integer.parseInt(st.nextToken());
        final char[] targetArray = br.readLine().toCharArray();
        final char[] dataArray = br.readLine().toCharArray();
        char[] targetCharCount = new char['z' + 1];
        char[] tempCount = new char['z' + 1];

        for (int i = 0; i < targetSize; i++) {
            targetCharCount[targetArray[i]]++;
        }

        //init slide
        for (int i = 0; i < targetSize-1; i++) {
            tempCount[dataArray[i]]++;
        }

        int firstPivot = 0;
        int result = 0;

        while (firstPivot + targetSize <= dataSize) {
            tempCount[dataArray[firstPivot + targetSize - 1]]++;
            if(Arrays.equals(targetCharCount, tempCount)) {
                result++;
            }
            tempCount[dataArray[firstPivot]]--;
            firstPivot++;
        }
        sb.append(result);



        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
