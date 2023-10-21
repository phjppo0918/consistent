package org.example.cbustudy.week1.bj12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int partSize = Integer.parseInt(st.nextToken());

        final String code = br.readLine();

        int[] needCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // A C G T

        Map<Character, Integer> counter = new HashMap();
        counter.put('A', 0);
        counter.put('C', 0);
        counter.put('G', 0);
        counter.put('T', 0);

        for (int i = 0; i < partSize; i++) {
            char next = code.charAt(i);
            counter.put(next, counter.get(next) + 1);
        }
        int answer = 0;
        for (int i = 0; i + partSize < size; i++) {
            if (needCount[0] <= counter.get('A') &&
                    needCount[1] <= counter.get('C') &&
                    needCount[2] <= counter.get('G') &&
                    needCount[3] <= counter.get('T')) {
                answer++;
            }
            char before = code.charAt(i);
            char next = code.charAt(i + partSize);
            counter.put(before, counter.get(before) - 1);
            counter.put(next, counter.get(next) + 1);
        }
        if (needCount[0] <= counter.get('A') &&
                needCount[1] <= counter.get('C') &&
                needCount[2] <= counter.get('G') &&
                needCount[3] <= counter.get('T')) {
            answer++;
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
