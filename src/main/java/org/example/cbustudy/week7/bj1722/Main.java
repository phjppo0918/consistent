package org.example.cbustudy.week7.bj1722;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX = 25;
        int jari = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int questionSize = Integer.parseInt(st.nextToken());
        long[] jariCount = new long[MAX];
        int[] sunArr = new int[MAX];
        boolean[] visited = new boolean[MAX];

        jariCount[0] = 1;
        for (int i = 1; i <= jari; i++) {
            jariCount[i]  = jariCount[i-1] * i;
        }

        if(questionSize == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= jari; i++) {
                int cnt = 1;
                for (int j = 1; j <= jari; j++) {

                    if(visited[j]) {
                        continue;
                    }
                    if(k <= cnt * jariCount[jari - i]) {
                        k -= (cnt -1) * jariCount[jari - i];
                        sunArr[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <=jari ; i++) {
                sb.append(sunArr[i]).append(" ");
            }
        }else {
            long k = 1;
            for (int i = 1; i <= jari; i++) {
                sunArr[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < sunArr[i]; j++) {
                    if (visited[j] == false) {
                        cnt++; // 미사용 숫자 개수만큼 카운트
                    }
                }
                k += cnt * jariCount[jari - i]; // 자리수 개수에 따라 순서 더해주기
                visited[sunArr[i]] = true;
            }
            sb.append(k);
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
