package org.example.sgtree.bj10868;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int querySize = Integer.parseInt(st.nextToken());
        int leng = nodeSize;
        int treeHeight = 0;
        while (leng > 0) {
            leng /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int nodeAddIndex = treeSize / 2 - 1;
        tree = new int[treeSize + 1];
        for (int i = nodeAddIndex + 1; i <= nodeAddIndex + nodeSize; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (int i = nodeAddIndex; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0; i < querySize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            List<Integer> selects = new ArrayList<>();
            int startIndex = start + nodeAddIndex;
            int endIndex = end + nodeAddIndex;

            while (startIndex <= endIndex) {
                if (startIndex % 2 == 1) {
                    selects.add(tree[startIndex]);
                    startIndex++;
                }
                startIndex = startIndex / 2;
                if (endIndex % 2 == 0) {
                    selects.add(tree[endIndex]);
                    endIndex--;
                }
                endIndex = endIndex / 2;
            }


            result.append(selects.stream().min(Comparator.naturalOrder()).get()).append("\n");

        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
