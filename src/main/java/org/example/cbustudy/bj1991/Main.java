package org.example.cbustudy.bj1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        char[][] data = new char[size][3];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = st.nextToken().charAt(0);
            data[i][1] = st.nextToken().charAt(0);
            data[i][2] = st.nextToken().charAt(0);
        }

        char[] tree = new char[100];
        tree[1] = 'A';

        Queue<Character> queue = new LinkedList<>();
        queue.add('A');

        while (!queue.isEmpty()) {
            char now = queue.poll();
            int nowIdx = 0;
            for (int i = 1; i < tree.length; i++) {
                if (tree[i] == now) {
                    nowIdx = i;
                    break;
                }
            }
            int dataIdx = 0;
            for (int i = 0; i < size; i++) {
                if (data[i][0] == now) {
                    dataIdx = i;
                    break;
                }
            }
            if (data[dataIdx][1] != '.') {
                tree[nowIdx * 2] = data[dataIdx][1];
                queue.add(data[dataIdx][1]);
            }

            if (data[dataIdx][2] != '.') {
                tree[nowIdx * 2 + 1] = data[dataIdx][2];
                queue.add(data[dataIdx][2]);
            }
        }

        sb
                .append(pre(tree, 1)).append("\n")
                .append(inorder(tree, 1)).append("\n")
                .append(post(tree, 1)).append("\n");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static String pre(char[] tree, int idx) {
        if (idx >= tree.length || tree[idx] == 0) {
            return "";
        }
        return tree[idx] + pre(tree, idx * 2) + pre(tree, idx * 2 + 1);
    }

    private static String inorder(char[] tree, int idx) {
        if (idx >= tree.length || tree[idx] == 0) {
            return "";
        }
        return inorder(tree, idx * 2) + tree[idx] + inorder(tree, idx * 2 + 1);
    }

    private static String post(char[] tree, int idx) {
        if (idx >= tree.length || tree[idx] == 0) {
            return "";
        }
        return post(tree, idx * 2) + post(tree, idx * 2 + 1) + tree[idx];
    }

}
