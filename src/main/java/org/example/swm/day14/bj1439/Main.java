package org.example.swm.day14.bj1439;

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


        final String input = br.readLine();

        char last = input.charAt(0);

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == last) {
                continue;
            }
            if(last == '0') {
                zeroCount++;
            }else {
                oneCount++;
            }
            last = input.charAt(i);
        }

        int min = Math.max(oneCount, zeroCount);

        sb.append(min);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
