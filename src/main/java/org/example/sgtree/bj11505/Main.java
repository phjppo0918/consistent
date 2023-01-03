package org.example.sgtree.bj11505;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    final static int DEVIDE_VALUE = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int changeCount = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());
        int nodeSize = 0;
        int leng = nodeCount;
        while (leng > 0) {
            leng /= 2;
            nodeSize++;
        }
        int treeSize = (int) Math.pow(2, nodeSize + 1);
        int nodeAddIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = nodeAddIndex + 1; i <= nodeAddIndex + nodeCount; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        for (int i = nodeAddIndex; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % DEVIDE_VALUE;
        }

        for (int i = 0; i < changeCount + sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if (command == 1) {
                int startIndex = start + nodeAddIndex;
                tree[startIndex] = end;
                for (int j = startIndex/2; j > 0;j/=2) {
                    tree[j] = tree[j * 2] % DEVIDE_VALUE * tree[j * 2 + 1] % DEVIDE_VALUE;
                }
            } else {
                long mul = 1;
                int startIndex = start + nodeAddIndex;
                long endIndex = end + nodeAddIndex;

                while (startIndex <= endIndex) {
                    if (startIndex % 2 == 1) {
                        mul = mul * tree[startIndex] % DEVIDE_VALUE;
                        startIndex++;
                    }
                    startIndex = startIndex / 2;
                    if (endIndex % 2 == 0) {
                        mul = mul * tree[(int) endIndex] % DEVIDE_VALUE;
                        endIndex--;
                    }
                    endIndex = endIndex / 2;
                }
                result.append(mul).append("\n");
            }
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
