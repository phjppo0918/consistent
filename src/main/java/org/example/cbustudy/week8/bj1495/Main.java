package org.example.cbustudy.week8.bj1495;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static Map<String, Integer> count = new HashMap<>();
    static Map<String, String> union = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            final int memberCount = Integer.parseInt(br.readLine());
            count.clear();
            union.clear();
            for (int j = 0; j < memberCount; j++) {
                st = new StringTokenizer(br.readLine());

                String m1 = st.nextToken();
                String m2 = st.nextToken();

                if (m1.compareTo(m2) > 0) {
                    String temp = m1;
                    m1 = m2;
                    m2 = temp;
                }
                if(!union.containsKey(m1)) {
                    union.put(m1, m1);
                    count.put(m1, 1);
                }
                if(!union.containsKey(m2)) {
                    union.put(m2, m2);
                    count.put(m2, 1);
                }

                if(!Objects.equals(uni(m1), uni(m2))) {
                    count.put(uni(m1), count.get(uni(m2))+ count.get(uni(m1)));
                    union.put(uni(m2),uni(m1));
                }

                sb.append(count.get(uni(m1))).append("\n");
            }
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    static String uni(String a) {
        if(Objects.equals(a, union.get(a))) {
            return a;
        }
        union.put(a, uni(union.get(a)));

        return union.get(a);
    }
}
