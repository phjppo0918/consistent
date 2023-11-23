package org.example.cbustudy.week6.bj10868;

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
        int searchCount = Integer.parseInt(st.nextToken());

        int k = 1;
        while (k < nodeCount) {
            k *= 2;
        }
        k *= 2;
        long[] tree = new long[k];
        int pivot = k / 2 - 1;

        for (int i = k / 2; i < k / 2 + nodeCount; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        while (pivot > 0) {
            tree[pivot] = Math.min(tree[pivot * 2] , tree[pivot * 2 + 1]);
            pivot--;
        }

        for (int i = 0; i < searchCount; i++) {
            st = new StringTokenizer(br.readLine());
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());


            long ans = Integer.MAX_VALUE;
            int start = (int) n1 + k / 2 - 1;
            int end = (int) n2 + k / 2 - 1;

            while (start <= end) {
                if (start % 2 == 1) {
                    ans = Math.min(tree[start], ans);
                    start++;
                }
                if (end % 2 == 0) {
                    ans = Math.min(tree[end], ans);
                    end--;
                }

                start /= 2;
                end /= 2;
            }

            sb.append(ans).append("\n");
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
