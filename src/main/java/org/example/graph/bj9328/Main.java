package org.example.graph.bj9328;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static Set<Character> key;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gameSize = Integer.parseInt(st.nextToken());

        for (int i = 0; i < gameSize; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph = new char[row][];
            for (int j = 0; j < row; j++) {
                graph[j] = br.readLine().toCharArray();
            }
            key = new HashSet<>();
            char[] newKey = br.readLine().toCharArray();

            for (char c : newKey) {
                key.add(c);
            }
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (graph[j][k] >= 'A' && graph[j][k] <= 'Z') {

                    }
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
