package org.example.greedy.bj1024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        List<Long> ans = new ArrayList<>();
        while (size <= 100) {
            long start = num / size - (size - 1) / 2;
            if (start < 0) {
                break;
            }

            if (num == (start * 2 + size - 1) * size/2) {
                for (long i = start; i < start + size ; i++) {
                    ans.add(i);
                }
                break;
            }
            size++;
        }

        if(ans.isEmpty()) {
            sb.append(-1 );
        }else {
            for(Long i : ans) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
