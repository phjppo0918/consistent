package org.example.cbustudy.week8.bj1495;

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


        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            Map<String, String> map = new HashMap<>();

            final int pairSize = Integer.parseInt(br.readLine());
            for (int j = 0; j < pairSize; j++) {
                st = new StringTokenizer(br.readLine());
                String m1 = st.nextToken();
                String m2 = st.nextToken();
                if(!map.containsKey(m1)) {
                    map.put(m1, new HashSet<>());
                    map.get(m1).add(m1);
                }
                if(!map.containsKey(m2)) {
                    map.put(m2, new HashSet<>());
                    map.get(m2).add(m2);
                }

                map.get(m1).addAll(map.get(m2));
                map.get(m2).addAll(map.get(m1));

                sb.append(map.get(m1).size()).append("\n");
            }


        }

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
