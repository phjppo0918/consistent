package org.example.cbustudy.week6.bj11505;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int changeCount = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());

        int k = 1;
        while (k < nodeCount) {
            k *= 2;
        }
        k *=2;
        long[] tree = new long[k];
        int pivot = k/ 2 - 1;

        for (int i = k/2; i < k/2+ nodeCount; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        while (pivot > 0) {
            tree[pivot] =( tree[pivot * 2] * tree[pivot * 2 + 1]) % MOD;
            pivot--;
        }

        for (int i = 0; i < changeCount + sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());

            if(command == 1) {
                int targetIdx = k/2 -1 + (int)n1;
                long after = n2;
                tree[targetIdx] = after;
                while (targetIdx > 1) {
                    targetIdx/=2;
                    tree[targetIdx] = tree[targetIdx * 2] % MOD * tree[targetIdx * 2 + 1] % MOD;
                }
            }else {
                long ans = 1;
                int start = (int)n1 + k/2 - 1;
                int end = (int)n2 + k/2 -1;

                while (start <= end) {
                    if(start%2 == 1) {
                        ans *= tree[start];
                        ans %= MOD;
                        start++;
                    }
                    if(end%2 == 0) {
                        ans *= tree[end];
                        ans %=  MOD;
                        end--;
                    }

                    start/=2;
                    end/=2;
                }

                sb.append(ans).append("\n");
            }
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
