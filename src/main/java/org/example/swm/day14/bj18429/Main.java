package org.example.swm.day14.bj18429;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int kitSize;
    static int minus;
    static int[] kits;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        kitSize = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());

        kits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < kitSize; i++) {
            final ArrayList<Integer> visit = new ArrayList<>();
            visit.add(i);
            count += back(500, visit);
        }

        sb.append(count);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int back(int weight, List<Integer> visit) {
        weight -= minus;
        weight += kits[visit.get(visit.size()-1)];
        if(weight < 500) {
            return 0;
        }
        if(visit.size() == kitSize) {
            return 1;
        }


        int total = 0;
        for (int i = 0; i < kitSize; i++) {
            if(!visit.contains(i)) {
                List<Integer> next = new ArrayList<>(visit);
                next.add(i);
                total += back(weight, next);
            }
        }

        return total;
    }
}
