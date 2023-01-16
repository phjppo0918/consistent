package org.example.backtracking.bj2731;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            String target = br.readLine();
            Long answer = 0L;
            long pivot = 1L;
            int strPivot = 1;
            for (int j = target.length() - 1; j >= 0; j--) {
                for (int k = 0; k < 10; k++) {
                    long temp = answer + (pivot * k);
                    BigInteger bigInteger = BigInteger.valueOf(temp);
                    String tempStr = bigInteger.pow(3).toString();
                    if(tempStr.length() - strPivot < 0) {
                        continue;
                    }
                    if (tempStr.substring(tempStr.length() - strPivot).equals(target.substring(target.length() - strPivot))) {
                        answer = temp;
                        strPivot++;
                        pivot *= 10;
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
