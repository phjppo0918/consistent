package org.example.dbn.bj4134;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    private static final long MAX_NUM = 4 * 1_000_000_000;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        long testCase = Integer.parseInt(br.readLine());

        for (int i=0;i<testCase;i++) {
            Long num = Long.parseLong(br.readLine());
            BigInteger bi = new BigInteger(String.valueOf(num));
            while (!bi.isProbablePrime(10)) {
                bi = bi.add(BigInteger.ONE);
            }
            sb.append(bi).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
