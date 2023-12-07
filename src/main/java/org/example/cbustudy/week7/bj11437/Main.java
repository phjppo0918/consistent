package org.example.cbustudy.week7.bj11437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[][] tree;
    static int[] depth;
    static boolean[] isVisited;
    static int depthSize;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());
        depthSize = 0;
        int depthPivot = 1;
        while (depthPivot <= nodeSize) {
            depthPivot *= 2;
            depthSize++;
        }
        tree = new int[depthSize + 1][nodeSize + 1];
        depth = new int[nodeSize + 1];
        isVisited = new boolean[nodeSize + 1];
        graph = new List[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeSize - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            graph[num2].add(num1);
        }
        setInitTree();
        setParentTree(nodeSize);
        int answerCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < answerCount; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            result.append(searchParent(num1, num2)).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void setParentTree(int nodeSize) {
        for (int i = 1; i <= depthSize; i++) {
            for (int j = 1; j <= nodeSize; j++) {
                tree[i][j] = tree[i - 1][tree[i - 1][j]];
            }
        }
    }

    private static int searchParent(int num1, int num2) {
        if (depth[num1] > depth[num2]) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int k = depthSize; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[num2] - depth[num1] &&
                    depth[num1] <= depth[tree[k][num2]]) {
                num2 = tree[k][num2];
            }
        } // 더 깊은 층 num1 층 까지 맞춤

        for (int k = depthSize; k >= 0; k--) {
            if (tree[k][num1] != tree[k][num2]) {
                num1 = tree[k][num1];
                num2 = tree[k][num2];
            }
        } // 층 올라가면서 같은 층 탐색

        if(num1 != num2) {
            return tree[0][num1];
        }
        return num1;
    }

    private static void setInitTree() {
        Queue<Integer> queue = new LinkedList<>();
        int head = 1;
        isVisited[head] = true;
        queue.add(head);
        int depthCount = 1;
        int elementCount = 0;
        int layerSize = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    tree[0][i] = now;
                    depth[i] = depthCount;
                    queue.add(i);
                }
            }
            elementCount++;
            if (elementCount == layerSize) {
                elementCount = 0;
                depthCount++;
                layerSize = queue.size();
            }
        }
    }
}
