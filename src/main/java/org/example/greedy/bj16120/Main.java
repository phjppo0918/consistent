package org.example.greedy.bj16120;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        int pCount = 0;
        boolean isNp = false;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'P') {
                pCount++;
            }else {
                if(i + 1 == chars.length || chars[i+1] != 'P' || pCount < 2) {
                    isNp = true;
                    break;
                }

                pCount-=1;
                i++;
            }
        }

        if(isNp || pCount != 1) {
            sb.append("NP");
        }else {
            sb.append("PPAP");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
