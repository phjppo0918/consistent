package org.example.cbustudy.week6.bj2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
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
            tree[pivot] = tree[pivot * 2] + tree[pivot * 2 + 1];
            pivot--;
        }

        for (int i = 0; i < changeCount + sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());

            if(command == 1) {
                int targetIdx = k/2 -1 + (int)n1;
                long gap = n2 - tree[targetIdx];
                while (targetIdx > 0) {
                    tree[targetIdx] += gap;
                    targetIdx/=2;
                }
            }else {
                long ans = 0;
                int start = (int)n1 + k/2 - 1;
                int end = (int)n2 + k/2 -1;

                while (start <= end) {
                    if(start%2 == 1) {
                        ans += tree[start];
                        start++;
                    }
                    if(end%2 == 0) {
                        ans += tree[end];
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
