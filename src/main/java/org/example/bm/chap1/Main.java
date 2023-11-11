package org.example.bm.chap1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());

        Main main = new Main();
        System.out.println(main.checkSame("1111"));

        final int value = main.test("(010)12345678", "19990909");
        sb.append(value);

        bw.write(sb.toString());

        bw.flush();
       // br.close();
        bw.close();
    }

    public int test(String phone, String bd) {
        int answer = 0;
        for (int i = 0; i <= 9999; i++) {
            String k = String.valueOf(i);
            while (k.length() != 4) {
                k = "0" + k;
            }
            if(!checkSame(k) && !checkPh(k, phone) && !checkStr(k, bd)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkSame(String no){
        for (int i = 0; i <= 9; i++) {
            int count = 0;
            for (int j = 0; j <4; j++) {
                if(no.charAt(j) == i + '0'){
                    count++;
                }
            }

            if(count >=3) {
                return true;
            }
        }

        return false;
    }

    private boolean checkStr(String no, String target) {
        int nPiv = 0;
        int tPiv = 0;

        while (nPiv < 4 && tPiv < target.length()) {
            if(no.charAt(nPiv) == target.charAt(tPiv)) {
                nPiv++;
            }
            tPiv++;
        }
        return nPiv >= 4;
    }

    private boolean checkPh(String no, String ph) {
        int nPiv = 0;
        int tPiv = 5;

        while (nPiv < 4 && tPiv < ph.length()) {
            if(no.charAt(nPiv) == ph.charAt(tPiv)) {
                nPiv++;
            }
            tPiv++;
        }
        return nPiv >= 4;
    }
}
