package org.example.sgtree.bj2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

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
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < changeCount + sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if (command == 1) {
                int startIndex = start + nodeAddIndex;
                long gap = end - tree[startIndex];
                while (startIndex > 0) {
                    tree[startIndex] = tree[startIndex] + gap;
                    startIndex/=2;
                }
            } else {
                long sum = 0;
                int startIndex = start + nodeAddIndex;
                long endIndex = end + nodeAddIndex;

                while (startIndex <= endIndex) {
                    if (startIndex % 2 == 1) {
                        sum += tree[startIndex];
                        startIndex++;
                    }
                    startIndex = startIndex / 2;
                    if (endIndex % 2 == 0) {
                        sum += tree[(int)endIndex];
                        endIndex--;
                    }
                    endIndex = endIndex / 2;
                }
                result.append(sum).append("\n");
            }
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
