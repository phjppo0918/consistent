package org.example.sameparent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sample {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[][] tree = new int[nodeSize + 1][nodeSize + 1];
        for (int i = 1; i < nodeSize - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree[0][child] = parent;
        }
        int height = 0;
        for (int i = 1; i < nodeSize; i++) {
            for (int j = nodeSize; j > 0; j--) {
                tree[i][j] = tree[i - 1][tree[i - 1][j - 1]];
            }
            if(tree[i][nodeSize] == 0) {
                height = i;
                break;
            }
        }

        int searchCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < searchCount; i++) {
            st = new StringTokenizer(br.readLine());
            int case1 = Integer.parseInt(st.nextToken());
            int case2 = Integer.parseInt(st.nextToken());
            int case1Depth = 0;
        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}