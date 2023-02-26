package org.example.impl.bj12904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String origin = br.readLine();
        String target = br.readLine();
        StringBuffer stringBuffer;
        while (origin.length() != target.length()) {
            char end = target.charAt(target.length() - 1);
            target = target.substring(0, target.length() - 1);
            if(end == 'B') {
                stringBuffer = new StringBuffer(target);
                target = stringBuffer.reverse().toString();
            }
        }
        if(origin.equals(target)) {
            sb.append(1);
        }else {
            sb.append(0);
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
