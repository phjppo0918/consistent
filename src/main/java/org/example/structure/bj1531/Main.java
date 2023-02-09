package org.example.structure.bj1531;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> dpMap = new HashMap<>();
    static long p;
    static long q;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        dpMap.put(0L, 1L);
        long answer = dp(n);
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static long dp(long num) {
        if (dpMap.containsKey(num)) {
            return dpMap.get(num);
        }
        long ret = dp(num / p) + dp(num / q);
        dpMap.put(num, ret);
        return ret;
    }
}
