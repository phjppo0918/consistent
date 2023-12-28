package org.example.cbustudy.week8.bj9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int[][] graph;
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        graph = new int[size][size];


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int back(int x, int y, int id) {
        if (graph[x][y] == 0) {
            graph[x][y] = id;
            count++;
            for (int i = x + 1; i < size; i++) {
                graph[i][y] = id;
            }
            for (int i = y + 1; i < size; i++) {
                graph[x][i] = id;
            }
            int xx = x + 1;
            int ly = y - 1;
            int ry = y + 1;

            while (xx < size) {
                if(ly >=0) {
                    graph[xx][ly] = id;
                }
                if(ry < size) {
                    graph[xx][ry] = id;
                }
                xx++;
                ly--;
                ry++;
            }

            

        }
    }
}
