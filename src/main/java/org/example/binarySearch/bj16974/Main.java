package org.example.binarySearch.bj16974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static long[] petty;
    private static long[] burgerSize;
    private static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int level = Integer.parseInt(st.nextToken());
        long eat = Long.parseLong(st.nextToken());

        petty = new long[level + 2];
        burgerSize = new long[level + 2];

        petty[0] = 1;
        burgerSize[0] = 1;

        for (int i = 0; i <= level; i++) {
            petty[i + 1] = petty[i] * 2 + 1;
            burgerSize[i + 1] = burgerSize[i] * 2 + 3;
        }
        search(level, eat);

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void search(int level, long eat) {
        if (eat == 0) return;
        if (level == 0) {
            answer++;
            return;
        }
        //맨 처음 빵 먹음
        eat--;

        if (eat == burgerSize[level - 1]) {
            answer += petty[level - 1];
        } else if (eat > burgerSize[level - 1]) { // 중간 패티 포함 먹음
            answer += (petty[level - 1] + 1);
            eat -= (burgerSize[level - 1] + 1);
            search(level - 1, eat);
        } else {
            search(level - 1, eat);
        }
    }
}
